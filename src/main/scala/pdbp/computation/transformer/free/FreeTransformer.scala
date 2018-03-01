package pdbp.computation.transformer.free

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

private[pdbp] object freeTransformer {

  sealed trait Free[M[+ _], +Z]

  final case class LiftObject[M[+ _], +Z](z: Z) extends Free[M, Z]
  final case class LiftComputation[M[+ _], +Z](mz: M[Z]) extends Free[M, Z]
  final case class Bind[M[+ _], -Z, ZZ <: Z, +Y](fmzz: Free[M, ZZ],
                                           `z=>fmy`: Z => Free[M, Y])
      extends Free[M, Y]

  type FreeTransformed = [M[+ _]] => [+Z] => Free[M, Z]

}

import freeTransformer._

import pdbp.types.implicitFunctionType.`I=>`

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.program.Program

import pdbp.computation.lifting.LiftingObject

import pdbp.program.Execution

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.NaturalTransformer

import pdbp.computation.transformer.NaturalComputationTransformer

import pdbp.computation.lower.ComputationLower

private[pdbp] trait FreeTransformer[M[+ _]: LiftingObject : [M[+ _]] => Execution[Kleisli[M]]]
    extends Computation[FreeTransformed[M]]
    with Program[Kleisli[FreeTransformed[M]]]
    with NaturalComputationTransformer[M, FreeTransformed[M]]
    with ComputationLower[FreeTransformed[M], M]
    with ProgramTransformer[Kleisli[M], Kleisli[FreeTransformed[M]]] {

  private type FTM = FreeTransformed[M]

  override private[pdbp] def liftObject[Z]: Z => FTM[Z] = { z =>
    LiftObject[M, Z](z)
  } 

  override private[pdbp] def apply[Z](mz: M[Z]): FTM[Z] =
    LiftComputation[M, Z](mz)

  override private[pdbp] def bind[Z, Y](ftmz: FTM[Z],
                                        `z=>ftmy`: Z => FTM[Y]): FTM[Y] =
    Bind[M, Z, Z, Y](ftmz, `z=>ftmy`)

  private[pdbp] def liftNaturalTransformer[N[+ _]: Computation](`M~>N`: NaturalTransformer[M, N]): NaturalTransformer[FTM, N] = 
    new NaturalTransformer[FTM, N]() {
    val implicitComputation = implicitly[Computation[N]]
    import implicitComputation.{result => resultN}
    import implicitComputation.{bind => bindN}
    override def apply[Z](ftmz: FTM[Z]): N[Z] = ftmz match {
      case LiftObject(z) => 
        resultN(z)
      case LiftComputation(mz) =>
        `M~>N`(mz)
      case Bind(my, y2ftmz) =>
        bindN(apply(my), y2ftmz andThen apply)
      case _ =>
        sys.error(
          "Impossible, since, for 'FreeTransformer', 'liftComputation' eliminates this case")          
    }
  }

  private type `>=K=>` = Kleisli[M]

  private type `>=FTK=>` = Kleisli[FTM]
  
  import implicitLiftingObject.{liftObject => liftObjectM}
  import implicitExecution.{Environment => EnvironmentK}
  import implicitExecution.{execute => executeK}

  override type Environment = EnvironmentK

  override val environment: Environment = implicitExecution.environment

  override def execute(`u>=ftk=>u`: Unit `>=FTK=>` Unit): Environment `I=>` Unit =
    executeK(lowerProgram(`u>=ftk=>u`))  

  @annotation.tailrec
  private final def lowerComputationHelper[Z](ftmz: FTM[Z]): M[Z] = ftmz match {
    case LiftObject(z) => 
      liftObjectM(z)
    case LiftComputation(mz) =>
      mz
    case Bind(LiftObject(y), y2ftmz) => 
      lowerComputationHelper(y2ftmz(y)) 
    case Bind(Bind(mx, x2ftmy), y2ftmz) =>
      // lowerComputationHelper(bind(mx, x => bind(x2ftmy(x), y2ftmz)))
      lowerComputationHelper(bind(mx, compose(x2ftmy, y2ftmz)))          
    case any =>
      sys.error(
        "Impossible, since, for 'FreeTransformer', 'lowerComputationHelper' eliminates this case")
    } 

  override private[pdbp] def lowerComputation[Z](ftmz: FTM[Z]): M[Z] = { 
    lowerComputationHelper(ftmz)
  } 

}

