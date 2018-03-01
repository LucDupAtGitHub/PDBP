package pdbp.program.writing.folding

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

import pdbp.computation.lifting.ObjectLifting

private[pdbp] trait Starting[W] 
  extends ObjectLifting[Const[W]] {

  private[pdbp] val start: W

  override private[pdbp] def liftObject[Z]: Z => W = { _ =>
    start
  }  

}

