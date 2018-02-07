package pdbp.types.active.reading.int.writing.log

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

import pdbp.types.active.reading.writing.log.activeReadingWithLogWritingTypes._ 

object activeIntReadingWithLogWritingTypes {

  type ActiveIntReadingWithLogWriting = ActiveReadingWithLogWriting[BigInt]

  type `>-airlw->`= `>-arlw->`[BigInt]

}