package pdbp.computation.transformer.writing.log

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

import pdbp.computation.transformer.writing.writingTransformer._

import pdbp.computation.transformer.writing.WritingTransformer

private[pdbp] object logWritingTransformer {

  type LogWritingTransformed = [M[+ _]] => WritingTransformed[Log, M]

}

private[pdbp] trait LogWritingTransformer[M[+ _]: Computation]
    extends WritingTransformer[Log, M]