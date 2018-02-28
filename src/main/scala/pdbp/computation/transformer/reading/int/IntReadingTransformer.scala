package pdbp.computation.transformer.reading.int

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

import pdbp.computation.Computation

import pdbp.computation.transformer.reading.readingTransformer._

import pdbp.computation.transformer.reading.ReadingTransformer

private[pdbp] object intReadingTransformer {

  type IntReadingTransformed = [M[+ _]] => ReadingTransformed[BigInt, M]

}

private[pdbp] trait IntReadingTransformer[M[+ _]: Computation]
    extends ReadingTransformer[BigInt, M]