package pdbp.program.writing.folding.instances.log

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.types.log.logTypes._

import pdbp.utils.productUtils._

import pdbp.program.writing.folding.Folding

private[pdbp] object logFolding extends Folding[Log] {

  override private[pdbp] val start: Log =
    Log { _ => () }

  override private[pdbp] val append: Log && Log => Log = { (l1, l2) =>
    Log { _ => { l1.effect(()) ; l2.effect(()) } }
  }   

}