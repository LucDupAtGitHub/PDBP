package examples.program.main.active.reading.int.console.writing.log.sl4j

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

import pdbp.types.active.reading.int.writing.log.activeIntReadingWithLogWritingTypes.`>-airlw->`

import pdbp.program.implicits.active.reading.int.console.writing.log.sl4j.implicits.implicitActiveIntReadingFromConsoleWithLogWritingUsingSl4jProgram

import examples.program.FactorialTrait

import examples.program.reading.int.FactorialMultipliedByIntReadTrait

import examples.program.writing.log.PointfulLogWritingFactorialTrait

import examples.program.reading.int.writing.log.PointfulLogWritingFactorialMultipliedByIntReadTrait

object PointfulLogWritingFactorialMultipliedByIntReadFromConsoleMain {

  object pointfulLogWritingFactorialMultipliedByIntReadFromConsoleObject 
    extends FactorialTrait[`>-airlw->`]()
    with FactorialMultipliedByIntReadTrait[`>-airlw->`]()
    with PointfulLogWritingFactorialTrait[`>-airlw->`]()
    with PointfulLogWritingFactorialMultipliedByIntReadTrait[`>-airlw->`]() 

  import pointfulLogWritingFactorialMultipliedByIntReadFromConsoleObject._

  def main(args: Array[String]): Unit = {

    executePointfulLogWritingFactorialMultipliedByIntReadProgram

  }

}
