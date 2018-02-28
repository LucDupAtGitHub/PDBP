package examples.program.main.active.writing.log.sl4j.free

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

import pdbp.types.active.writing.log.free.activeLogWritingWithFreeTypes.`>-alwf->`

import pdbp.program.implicits.active.writing.log.sl4j.free.implicits.implicitActiveLogWritingUsingSl4jFreeProgram

import examples.program.FactorialTrait

import examples.program.writing.log.PointfreeLogWritingFactorialTrait

object PointfreeLogWritingUsingSl4jFactorialMain {

  object pointfreeLogWritingUsingSl4jFactorialObject 
    extends PointfreeLogWritingFactorialTrait[`>-alwf->`]() 
    with FactorialTrait[`>-alwf->`]()

  import pointfreeLogWritingUsingSl4jFactorialObject._

  def main(args: Array[String]): Unit = {    

    executePointfreeLogWritingFactorialProgram

  }

}
