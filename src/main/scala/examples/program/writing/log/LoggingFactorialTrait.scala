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

import pdbp.program.writing.log.Logging

import examples.program.FactorialTrait

trait LoggingFactorialTrait
   [>-->[- _, + _]: Program : [>-->[- _, + _]] => Logging[>-->]]
     extends FactorialTrait[>-->] {

  import implicitProgram._

  val implicitLogging = implicitly[Logging[>-->]]

  import implicitLogging._  

  import pdbp.program.compositionOperator._

  import pdbp.utils.productUtils._

  import examples.utils.functionUtils._

  override val isPositive: BigInt >--> Boolean =
    //info("isPositive") {
      // function(isPositiveFunction)
      functionWithInfo("isPositive")(isPositiveFunction)
    //}

  override val subtractOne: BigInt >--> BigInt =
    //info("subtractOne") {
      // function(subtractOneFunction)
      functionWithInfo("subtractOne")(subtractOneFunction)
    //}

  override val multiply: (BigInt && BigInt) >--> BigInt =
    //info("multiply") {
      // function(multiplyFunction)
      functionWithInfo("multiply")(multiplyFunction)
    //}

  override def one[Z]: Z >--> BigInt =
    //info("one") {
      // function(oneFunction)
      functionWithInfo("one")(oneFunction)  
    //}

  def loggingFactorial: BigInt >--> BigInt =
    info("factorial") {
      `if`(isPositive) {
        `let` {
          subtractOne >-->
            loggingFactorial  
        } `in`
          multiply
      } `else` {
        one
      } 
    }

  val loggingFactorialProgram: Unit >--> Unit =
    producer >-->
      loggingFactorial >-->
      consumer

  def executeLoggingFactorialProgram: Unit =
    execute(loggingFactorialProgram)     

}
