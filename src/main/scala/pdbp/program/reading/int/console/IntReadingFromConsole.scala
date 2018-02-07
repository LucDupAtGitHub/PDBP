package pdbp.program.reading.int.console

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

import pdbp.program.Function

import pdbp.program.Composition

import pdbp.program.reading.int.IntReading

trait IntReadingFromConsole[>-->[- _, + _]] extends IntReading[>-->] {
  this: Function[>-->] & Composition[>-->] =>
  
  val readIntFromConsole: Unit >--> BigInt = 
    readInt("please type an integer to read")

}