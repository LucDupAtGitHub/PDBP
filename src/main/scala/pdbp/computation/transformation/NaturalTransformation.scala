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

private[pdbp] trait NaturalTransformation[M[+ _], N[+ _]] {

  private[pdbp] def apply[Z](dz: M[Z]): N[Z]

  private[pdbp] def transformComputation[Z](dz: M[Z]): N[Z] = 
    apply(dz)  

  private type `>-M->` = Kleisli[M]

  private type `>-N->` = Kleisli[N]  

  private[pdbp] def transformProgram[Z, Y](
      `z>-km->y`: Z `>-M->` Y): Z `>-N->` Y = { z =>
    apply[Y](`z>-km->y`(z))
  }   

}
