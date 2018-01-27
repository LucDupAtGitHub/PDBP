package examples.program.main.function

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

import pdbp.types.function.functionTypes.`>-=->`

import pdbp.program.implicits.function.implicits.implicitFunctionProgram

import examples.program.FibonacciTrait

object FibonacciMain {

  object fibonacciObject extends FibonacciTrait[`>-=->`]()

  import fibonacciObject._

  def main(args: Array[String]): Unit = {

    executeFibonacciProgram

  }


}
