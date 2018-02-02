package pdbp.types.active.writing

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

import pdbp.types.active.activeTypes._

import pdbp.computation.transformer.writing.writingTransformer._

object activeWritingTypes {

  type ActiveWriting = [W] => WritingTransformed[W, Active]

  type `>-aw->`= [W] => Kleisli[ActiveWriting[W]]

}