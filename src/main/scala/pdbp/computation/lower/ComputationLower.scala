package pdbp.computation.lower

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

private[pdbp] trait ComputationLower[U[+ _], D[+ _]] {

  private[pdbp] def lowerComputation[Z](uz: U[Z]): D[Z]

  private type `>-D->` = Kleisli[D]

  private type `>-U->` = Kleisli[U]

  private[pdbp] def lowerProgram[Z, Y](
      `z>-u->y`: Z `>-U->` Y): Z `>-D->` Y = { z =>
    lowerComputation(`z>-u->y`(z))
  }

}
