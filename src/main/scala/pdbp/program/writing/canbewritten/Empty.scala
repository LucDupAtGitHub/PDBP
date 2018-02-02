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

import pdbp.lifting.LiftObject

private[pdbp] trait Empty[W] 
  extends LiftObject[Const[W]] {

  private[pdbp] val empty: W

  override private[pdbp] def liftObject[Z]: Z => W = { _ =>
    empty
  }  

}

