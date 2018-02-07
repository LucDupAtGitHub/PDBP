package pdbp.program.reading.int

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

// import pdbp.utils.runUtils._

import pdbp.program.Function

import pdbp.program.Composition

import pdbp.program.reading.Reading

trait IntReading[>-->[- _, + _]] extends Reading[BigInt, >-->] {
  this: Function[>-->] & Composition[>-->] =>

}
