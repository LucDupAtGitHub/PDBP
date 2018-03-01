package pdbp.computation.transformation.writing.log

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

import pdbp.types.log.logTypes._

import pdbp.utils.productUtils._

import pdbp.computation.Computation

import pdbp.computation.transformation.writing.writingTransformation._

import pdbp.computation.transformation.writing.WritingTransformation

private[pdbp] object logWritingTransformation {

  type LogWritingTransformed = [M[+ _]] => WritingTransformed[Log, M]

}

private[pdbp] trait LogWritingTransformation[M[+ _]: Computation]
    extends WritingTransformation[Log, M]