package pdbp.computation.transformation.reading.int

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

import pdbp.computation.transformation.reading.readingTransformation._

import pdbp.computation.transformation.reading.ReadingTransformation

private[pdbp] object intReadingTransformation {

  type IntReadingTransformed = [M[+ _]] => ReadingTransformed[BigInt, M]

}

private[pdbp] trait IntReadingTransformation[M[+ _]: Computation]
    extends ReadingTransformation[BigInt, M]