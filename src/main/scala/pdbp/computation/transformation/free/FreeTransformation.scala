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

import pdbp.computation.resulting.Resulting

import pdbp.program.Execution

import pdbp.computation.Computation

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.~>

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait FreeTransformation[M[+ _]: Resulting: [M[+ _]] => Execution[Kleisli[M]]]
    extends Computation[FreeTransformed[M]]
    with Program[Kleisli[FreeTransformed[M]]]
    with ComputationTransformation[M, FreeTransformed[M]]
    with (FreeTransformed[M] ~> M)
    with ProgramTransformation[Kleisli[M], Kleisli[FreeTransformed[M]]] {

  private[pdbp] val implicitResulting = implicitly[Resulting[M]]  

  private type FTM = FreeTransformed[M]

  override private[pdbp] def result[Z]: Z => FTM[Z] = { z =>
    Result[M, Z](z) 
  }  

  override private[pdbp] def transformComputation = new (M ~> FTM) {
    override private[pdbp] def apply[Z](mz: M[Z]): FTM[Z] = 
      TransformComputation[M, Z](mz)  
  }

  override private[pdbp] def bind[Z, Y](ftmz: FTM[Z],
                                        `z=>ftmy`: Z => FTM[Y]): FTM[Y] =
    Bind[M, Z, Z, Y](ftmz, `z=>ftmy`)

  private[pdbp] def extendTransformationToFree[N[+ _]: Computation](`m~>n`: M ~> N): FTM ~> N = 
    new (FTM ~> N)() {
    val implicitComputation = implicitly[Computation[N]]
    import implicitComputation.{result => resultN}
    import implicitComputation.{bind => bindN}
    override def apply[Z](ftmz: FTM[Z]): N[Z] = ftmz match {
      case Result(z) => 
        resultN(z)
      case TransformComputation(mz) =>
        `m~>n`(mz)
      case Bind(my, y2ftmz) =>
        bindN(apply(my), y2ftmz andThen apply)
      case _ =>
        sys.error(
          "Impossible, since, for 'FreeTransformation', 'extendTransformationToFree' eliminates this case")          
    }
  }

  private type `>=K=>` = Kleisli[M]

  private type `>=FTK=>` = Kleisli[FTM]

  import implicitResulting.{result => resultM}

  import implicitExecution.{Environment => EnvironmentK}
  import implicitExecution.{execute => executeK}

  override type Environment = EnvironmentK

  override val environment: Environment = implicitExecution.environment

  override def execute(`u>=ftk=>u`: Unit `>=FTK=>` Unit): Environment `I=>` Unit =
    executeK { z => apply(`u>=ftk=>u`(z)) }

  @annotation.tailrec
  private final def applyHelper[Z](ftmz: FTM[Z]): M[Z] = ftmz match {
    case Result(z) => 
      resultM(z)
    case TransformComputation(mz) =>
      mz
    case Bind(Result(y), y2ftmz) => 
      applyHelper(y2ftmz(y)) 
    case Bind(Bind(mx, x2ftmy), y2ftmz) =>
      // applyHelper(bind(mx, x => bind(x2ftmy(x), y2ftmz)))
      applyHelper(bind(mx, compose(x2ftmy, y2ftmz)))          
    case any =>
      sys.error(
        "Impossible, since, for 'FreeTransformation', 'applyHelper' eliminates this case")
    } 

  override private[pdbp] def apply[Z](ftmz: FTM[Z]): M[Z] = { 
    applyHelper(ftmz)
  } 

}


