package pdbp.binding

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

import pdbp.utils.functionUtils._

import pdbp.lifting.Lifting

private[pdbp] trait Binding[M[+ _]] {
  this: Lifting[M] =>

  private[pdbp] def bind[Z, Y](mz: M[Z], `z=my`: Z => M[Y]): M[Y] =
    flatten(liftFunction(`z=my`)(mz))

  private[pdbp] def flatten[Z](mmz: M[M[Z]]): M[Z] =
    bind(mmz, `mz=>mz`)

}
