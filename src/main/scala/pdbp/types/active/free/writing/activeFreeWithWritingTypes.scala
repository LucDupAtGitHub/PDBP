package pdbp.types.active.free.writing

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

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.computation.transformation.free.freeTransformation._

object activeFreeWithWritingTypes {

  type ActiveFreeWithWriting = [W] => FreeTransformed[ActiveWriting[W]]

  type `>-afw->`= [W] => Kleisli[ActiveFreeWithWriting[W]]

}