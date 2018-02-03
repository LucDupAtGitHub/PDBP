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

private[pdbp] object freeTransformer {

  sealed trait Free[M[+ _], +Z]

  case class LiftingObject[M[+ _], +Z](z: Z) extends Free[M, Z]
  case class Bind[M[+ _], -Z, ZZ <: Z, +Y](fmzz: Free[M, ZZ],
                                           `z=>fmy`: Z => Free[M, Y])
      extends Free[M, Y]

  type FreeTransformed = [M[+ _]] => [+Z] => Free[M, Z]

}

import freeTransformer._

import pdbp.types.implicitFunctionType.`I=>`

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

private[pdbp] trait FreeTransformer[M[+ _]: Computation]
    extends Computation[FreeTransformed[M]]
    with Program[Kleisli[FreeTransformed[M]]]
    with ComputationTransformer[M, FreeTransformed[M]]
    with ProgramTransformer[Kleisli[M], Kleisli[FreeTransformed[M]]] {

  private type FTM = FreeTransformed[M]

  override private[pdbp] def liftComputation[Z](mz: M[Z]): FTM[Z] =
    sys.error(
      "Impossible, since, for 'FreeTransformer', 'liftComputation' is used nowhere")

  override private[pdbp] def liftObject[Z]: Z => FTM[Z] = { z =>
    LiftingObject[M, Z](z)
  }

  override private[pdbp] def bind[Z, Y](ftmz: FTM[Z],
                                        `z=>ftmy`: Z => FTM[Y]): FTM[Y] =
    Bind[M, Z, Z, Y](ftmz, `z=>ftmy`)

  private type `>=K=>` = Kleisli[M]

  private type `>=FTK=>` = Kleisli[FTM]

  import implicitComputation.{result => resultM}
  import implicitProgram.{Environment => EnvironmentK}
  import implicitProgram.{execute => executeK}

  override type Environment = EnvironmentK

  override val environment: Environment = implicitProgram.environment

  override def execute(`u>=ftk=>u`: Unit `>=FTK=>` Unit): Environment `I=>` Unit =
    executeK(lower(`u>=ftk=>u`))

  private[pdbp] def lower[Z, Y](
      `z>=ftk=>y`: Z `>=FTK=>` Y): Z `>=K=>` Y = { z =>
    @annotation.tailrec
    def step[Z](ftmz: FTM[Z]): FTM[Z] = ftmz match {
      case Bind(Bind(mx, x2ftmy), y2ftmz) =>
        // step(bind(mx, x => bind(x2ftmy(x), y2ftmz)))
        step(bind(mx, compose(x2ftmy, y2ftmz)))
      case Bind(LiftingObject(y), y2ftmz) => step(y2ftmz(y))
      case              _              => ftmz
    }
    step(`z>=ftk=>y`(z)) match {
      case LiftingObject(z) => resultM(z)
      case _ =>
        sys.error(
          "Impossible, since, for 'FreeTransformer', 'step' eliminates this case")
    }
  }  

}

