package pdbp.computation.transformation.free

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library
//  author        Luc Duponcheel        2017-2018

//import pdbp.computation.~>

private[pdbp] object freeTransformation {

  sealed trait Free[M[+ _], +Z]

  final case class Result[M[+ _], +Z](z: Z) extends Free[M, Z]
  final case class TransformComputation[M[+ _], +Z](mz: M[Z]) extends Free[M, Z]
  final case class Bind[M[+ _], -Z, ZZ <: Z, +Y](fmzz: Free[M, ZZ],
                                           `z=>fmy`: Z => Free[M, Y])
      extends Free[M, Y]

  type FreeTransformed = [M[+ _]] => [+Z] => Free[M, Z]

}

import freeTransformation._

import pdbp.types.implicitFunctionType.`I=>`

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.program.Program

import pdbp.computation.lifting.ObjectLifting

import pdbp.program.Execution

import pdbp.computation.Computation

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.NaturalTransformation

import pdbp.computation.transformation.ComputationTransformation

import pdbp.computation.recuperation.NaturalRecuperation

private[pdbp] trait FreeTransformation[M[+ _]: [M[+ _]] => Execution[Kleisli[M]]: ObjectLifting ]
    extends Computation[FreeTransformed[M]]
    with Program[Kleisli[FreeTransformed[M]]]
    with ComputationTransformation[M, FreeTransformed[M]]
    with NaturalRecuperation[FreeTransformed[M], M]
    with ProgramTransformation[Kleisli[M], Kleisli[FreeTransformed[M]]] {

  private[pdbp] val implicitObjectLifting = implicitly[ObjectLifting[M]]  

  private type FTM = FreeTransformed[M]

  override private[pdbp] def result[Z]: Z => FTM[Z] = { z =>
    Result[M, Z](z) 
  }  

  override private[pdbp] def transformComputation[Z](mz: M[Z]): FTM[Z] =
    TransformComputation[M, Z](mz)

  override private[pdbp] def bind[Z, Y](ftmz: FTM[Z],
                                        `z=>ftmy`: Z => FTM[Y]): FTM[Y] =
    Bind[M, Z, Z, Y](ftmz, `z=>ftmy`)

  private[pdbp] def extendNaturalTransformation[N[+ _]: Computation](`M~>N`: NaturalTransformation[M, N]): NaturalTransformation[FTM, N] = 
    new NaturalTransformation[FTM, N]() {
    val implicitComputation = implicitly[Computation[N]]
    import implicitComputation.{result => resultN}
    import implicitComputation.{bind => bindN}
    override def apply[Z](ftmz: FTM[Z]): N[Z] = ftmz match {
      case Result(z) => 
        resultN(z)
      case TransformComputation(mz) =>
        `M~>N`(mz)
      case Bind(my, y2ftmz) =>
        bindN(apply(my), y2ftmz andThen apply)
      case _ =>
        sys.error(
          "Impossible, since, for 'FreeTransformation', 'extendNaturalTransformation' eliminates this case")          
    }
  }

  private type `>=K=>` = Kleisli[M]

  private type `>=FTK=>` = Kleisli[FTM]

  import implicitObjectLifting.{liftObject => liftObjectM}

  import implicitExecution.{Environment => EnvironmentK}
  import implicitExecution.{execute => executeK}

  override type Environment = EnvironmentK

  override val environment: Environment = implicitExecution.environment

  override def execute(`u>=ftk=>u`: Unit `>=FTK=>` Unit): Environment `I=>` Unit =
    executeK(recuperateProgram(`u>=ftk=>u`))  

  @annotation.tailrec
  private final def recuperateHelper[Z](ftmz: FTM[Z]): M[Z] = ftmz match {
    case Result(z) => 
      liftObjectM(z)
    case TransformComputation(mz) =>
      mz
    case Bind(Result(y), y2ftmz) => 
      recuperateHelper(y2ftmz(y)) 
    case Bind(Bind(mx, x2ftmy), y2ftmz) =>
      // recuperateHelper(bind(mx, x => bind(x2ftmy(x), y2ftmz)))
      recuperateHelper(bind(mx, compose(x2ftmy, y2ftmz)))          
    case any =>
      sys.error(
        "Impossible, since, for 'FreeTransformation', 'recuperateHelper' eliminates this case")
    } 

  override private[pdbp] def recuperate[Z](ftmz: FTM[Z]): M[Z] = { 
    recuperateHelper(ftmz)
  } 

}

