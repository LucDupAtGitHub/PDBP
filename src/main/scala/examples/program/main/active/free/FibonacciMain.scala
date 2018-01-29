package examples.program.main.active.free

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.types.active.free.activeFreeTypes.`>-af->`

import pdbp.program.implicits.active.free.implicits.implicitActiveFreeProgram

import examples.program.FibonacciTrait

object FibonacciMain {

  object fibonacciObject extends FibonacciTrait[`>-af->`]()

  import fibonacciObject._

  def main(args: Array[String]): Unit = {

    executeFibonacciProgram

  }

}
