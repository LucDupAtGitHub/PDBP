package examples.program.main.active.free.writing.log.sl4j

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

import pdbp.types.active.free.writing.log.activeFreeWithLogWritingTypes.`>-aflw->`

import pdbp.program.implicits.active.free.writing.log.sl4j.implicits.implicitActiveFreeWithLogWritingUsingSl4jProgram

import examples.program.FactorialTrait

import examples.program.writing.log.PointfreeLogWritingFactorialTrait

object PointfreeLogWritingUsingSl4jFactorialMain {

  object pointfreeLogWritingUsingSl4jFactorialObject 
    extends PointfreeLogWritingFactorialTrait[`>-aflw->`]() 
    with FactorialTrait[`>-aflw->`]()

  import pointfreeLogWritingUsingSl4jFactorialObject._

  def main(args: Array[String]): Unit = {    

    executePointfreeLogWritingFactorialProgram

  }

}
