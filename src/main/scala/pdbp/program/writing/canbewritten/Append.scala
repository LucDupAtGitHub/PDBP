package pdbp.program.writing.canbewritten

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.types.const.constType._

import pdbp.utils.productUtils._

import pdbp.lifting.LiftOperator

private[pdbp] trait Append[W] extends LiftOperator[Const[W]] {

  private[pdbp] val append: W && W => W

  override private[pdbp] def liftOperator[Z, Y, X](
      `(z&&y)=>x`: (Z && Y) => X): (W && W) => W = append

}
