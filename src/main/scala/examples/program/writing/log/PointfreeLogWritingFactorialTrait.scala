package examples.program.writing.log

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

import pdbp.types.log.logTypes._

import pdbp.program.Program

import pdbp.program.writing.Writing

import pdbp.program.writing.log.LogWriting

import examples.program.FactorialTrait

trait PointfreeLogWritingFactorialTrait
   [>-->[- _, + _]: Program : [>-->[- _, + _]] => LogWriting[>-->]]
     extends FactorialTrait[>-->] {

  import implicitProgram._

  val implicitLogWriting = implicitly[LogWriting[>-->]]

  import implicitLogWriting._  

  import pdbp.program.compositionOperator._

  import pdbp.utils.productUtils._

  import examples.utils.functionUtils._

  override val isPositive: BigInt >--> Boolean =
    info("isPositive") {
      function(isPositiveFunction)
    }

  override val subtractOne: BigInt >--> BigInt =
    info("subtractOne") {
      function(subtractOneFunction)
    }

  override val multiply: (BigInt && BigInt) >--> BigInt =
    info("multiply") {
      function(multiplyFunction)
    }

  override def one[Z]: Z >--> BigInt =
    info("one") {
      function(oneFunction)
    }

  def pointfreeLogWritingFactorial: BigInt >--> BigInt =
    info("factorial") {
      `if`(isPositive) {
        `let` {
          subtractOne >-->
            pointfreeLogWritingFactorial  
        } `in`
          multiply
      } `else` {
        one
      } 
    }

  val pointfreeLogWritingFactorialProgram: Unit >--> Unit =
    producer >-->
      pointfreeLogWritingFactorial >-->
      consumer

  def executePointfreeLogWritingFactorialProgram: Unit =
    execute(pointfreeLogWritingFactorialProgram)     

}
