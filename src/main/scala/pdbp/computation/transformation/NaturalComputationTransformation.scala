package pdbp.computation.transformation

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

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.program.Execution

import pdbp.computation.Computation

import pdbp.computation.lifting.ObjectLifting

import pdbp.program.transformation.ProgramTransformation

private[pdbp] trait NaturalComputationTransformation[M[+ _]: ObjectLifting: [M[+ _]] => Execution[Kleisli[M]], N[+ _]]
    extends NaturalTransformation[M, N]
    with ObjectLifting[N]
    with ComputationTransformation[M, N]
    with ProgramTransformation[Kleisli[M], Kleisli[N]] {

  private[pdbp] val implicitObjectLifting = implicitly[ObjectLifting[M]]

  private[pdbp] val implicitExecution = implicitly[Execution[Kleisli[M]]]

  override private[pdbp] def liftObject[Z]: Z => N[Z] = { z =>
    apply(implicitObjectLifting.liftObject(z))
  }

  override private[pdbp] def transformComputation[Z](dz: M[Z]): N[Z] = apply(dz)

  private type `>-M->` = Kleisli[M]

  private type `>-N->` = Kleisli[N]

  override private[pdbp] def transformProgram[Z, Y](
      `z>-km->y`: Z `>-M->` Y): Z `>-N->` Y = { z =>
    apply[Y](`z>-km->y`(z))
  }  

}