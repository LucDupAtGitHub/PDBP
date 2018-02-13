package pdbp.types.active.reading.writing

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

import pdbp.computation.transformer.reading.readingTransformer._

object activeReadingWithWritingTypes {

  type ActiveReadingWithWriting = [R, W] => ReadingTransformed[R, ActiveWriting[W]]

  type `>-arw->`= [R, W] => Kleisli[ActiveReadingWithWriting[R, W]]

}

