package examples.program.main.active.writing.log.sl4j

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

import pdbp.types.active.writing.log.activeLoggingTypes.`>-al->`

import pdbp.program.implicits.active.writing.log.sl4j.implicits.implicitActiveLoggingUsingSl4jProgram

import examples.program.FactorialTrait

import examples.program.writing.log.LoggingFactorialTrait

object LoggingFactorialUsingSl4jMain {

  object loggingFactorialUsingSl4jObject 
    extends LoggingFactorialTrait[`>-al->`]() 
    with FactorialTrait[`>-al->`]()

  import loggingFactorialUsingSl4jObject._

  def main(args: Array[String]): Unit = {    

    executeLoggingFactorialProgram

  }

}
