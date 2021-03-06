package examples.program.main.active.reading.int.console

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

import pdbp.types.active.reading.int.activeIntReadingTypes.`>-air->`

import pdbp.program.implicits.active.reading.int.console.implicits.implicitActiveIntReadingFromConsoleProgram

import examples.program.FactorialTrait

import examples.program.reading.int.FactorialMultipliedByIntReadTrait

object FactorialMultipliedByIntReadFromConsoleMain {

  object factorialMultipliedByIntReadFromConsoleObject 
    extends FactorialTrait[`>-air->`]()
    with FactorialMultipliedByIntReadTrait[`>-air->`]() 

  import factorialMultipliedByIntReadFromConsoleObject._

  def main(args: Array[String]): Unit = {

    executeFactorialMultipliedByIntReadProgram

  }

}
