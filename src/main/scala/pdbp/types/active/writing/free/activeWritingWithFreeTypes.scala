package pdbp.types.active.writing.free

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.types.active.free.activeFreeTypes._

import pdbp.computation.transformation.writing.writingTransformation._

object activeWritingWithFreeTypes {

  type ActiveWritingWithFree = [W] => WritingTransformed[W, ActiveFree]

  type `>-awf->`= [W] => Kleisli[ActiveWritingWithFree[W]]

}
