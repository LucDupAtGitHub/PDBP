package examples.program.main.active

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

import pdbp.types.active.activeTypes.`>-a->`

import pdbp.program.implicits.active.implicits.implicitActiveProgram

import examples.program.FactorialTrait

object FactorialMain {

  object factorialObject extends FactorialTrait[`>-a->`]()

  import factorialObject._

  def main(args: Array[String]): Unit = {

    executeFactorialProgram

  }

}
