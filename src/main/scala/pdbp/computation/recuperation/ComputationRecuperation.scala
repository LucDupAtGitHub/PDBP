package pdbp.computation.recuperation

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

private[pdbp] trait ComputationRecuperation[N[+ _], M[+ _]] {

  private[pdbp] def recuperateComputation[Z](nz: N[Z]): M[Z]

  private type `>-M->` = Kleisli[M]

  private type `>-N->` = Kleisli[N]

  private[pdbp] def recuperateProgram[Z, Y](
      `z>-n->y`: Z `>-N->` Y): Z `>-M->` Y = { z =>
    recuperateComputation(`z>-n->y`(z))
  }

}
