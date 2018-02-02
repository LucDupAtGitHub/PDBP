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

import pdbp.utils.functionUtils._

import pdbp.lifting.Lifting

private[pdbp] trait CanBeWritten[M]
    extends Empty[M]
    with Append[M]
    with Lifting[Const[M]] {

  override private[pdbp] def liftFunction[Z, Y](`z=>y`: Z => Y): M => M =
    `m=>m`

}
