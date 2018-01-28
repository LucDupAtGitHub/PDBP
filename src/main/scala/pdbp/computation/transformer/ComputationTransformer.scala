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

import pdbp.lifting.LiftObject

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

trait ComputationTransformer[D[+ _]: Computation, U[+ _]]
    extends ProgramTransformer[Kleisli[D], Kleisli[U]]
    with LiftObject[U] {

  private[pdbp] def liftComputation[Z]: D[Z] => U[Z]

  private[pdbp] val implicitComputation = implicitly[Computation[D]]

  override private[pdbp] def liftObject[Z]: Z => U[Z] = { z =>
    liftComputation(implicitComputation.liftObject(z))
  }

  private type `>-D->` = Kleisli[D]

  private type `>-U->` = Kleisli[U]

  override private[pdbp] def liftProgram[Z, Y](
      `z>-d->y`: Z `>-D->` Y): Z `>-U->` Y = { z =>
    liftComputation[Y](`z>-d->y`(z))
  }

}
