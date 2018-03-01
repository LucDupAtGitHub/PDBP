package pdbp.computation.transformer

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

import pdbp.computation.lifting.LiftingObject

import pdbp.program.Execution

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

private[pdbp] trait ComputationTransformer[M[+ _], N[+ _]] {

  private[pdbp] def liftComputation[Z](dz: M[Z]): N[Z]

}

private[pdbp] trait NaturalTransformer[M[+ _], N[+ _]] {

  private[pdbp] def apply[Z](dz: M[Z]): N[Z]

}

private[pdbp] trait NaturalComputationTransformer[M[+ _]: LiftingObject: [M[+ _]] => Execution[Kleisli[M]], N[+ _]]
    extends NaturalTransformer[M, N]
    with LiftingObject[N]
    with ComputationTransformer[M, N]
    with ProgramTransformer[Kleisli[M], Kleisli[N]] {

  private[pdbp] val implicitLiftingObject = implicitly[LiftingObject[M]]

  private[pdbp] val implicitExecution = implicitly[Execution[Kleisli[M]]]

  override private[pdbp] def liftObject[Z]: Z => N[Z] = { z =>
    apply(implicitLiftingObject.liftObject(z))
  }

  override private[pdbp] def liftComputation[Z](dz: M[Z]): N[Z] = apply(dz)

  private type `>-KM->` = Kleisli[M]

  private type `>-KN->` = Kleisli[N]

  override private[pdbp] def liftProgram[Z, Y](
      `z>-km->y`: Z `>-KM->` Y): Z `>-KN->` Y = { z =>
    liftComputation[Y](`z>-km->y`(z))
  }  

}
