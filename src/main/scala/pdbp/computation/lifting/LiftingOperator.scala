package pdbp.computation.lifting

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

import pdbp.utils.productUtils._

private[pdbp] trait LiftingOperator[M[+ _]] {

  private[pdbp] def liftOperator[Z, Y, X](
      `(z&&y)=>x`: (Z && Y) => X): (M[Z] && M[Y]) => M[X] = { (mz, my) =>
    liftOperator[Z, Y, X] { (z, y) =>
      `(z&&y)=>x`(z, y)
    }(mz, my)
  }

  private[pdbp] def liftOperator[Z, Y, X](
      `(z,y)=>x`: (Z, Y) => X): (M[Z], M[Y]) => M[X] = { (mz, my) =>
    liftOperator[Z, Y, X] { (z, y) =>
      `(z,y)=>x`(z, y)
    }(mz, my)
  }

}
