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

trait PointfulLogWritingFactorialTrait[>-->[- _, + _]: Program : LogWriting]
     extends FactorialTrait[>-->] {

  import implicitProgram._

  val implicitLogWriting = implicitly[LogWriting[>-->]]

  import implicitLogWriting._  

  import pdbp.program.compositionOperator._

  import pdbp.utils.productUtils._

  import examples.utils.functionUtils._

  override val isPositive: BigInt >--> Boolean =
    functionWithInfo("isPositive")(isPositiveFunction)

  override val subtractOne: BigInt >--> BigInt =
    functionWithInfo("subtractOne")(subtractOneFunction)

  override val multiply: (BigInt && BigInt) >--> BigInt =
    functionWithInfo("multiply")(multiplyFunction)

  override def one[Z]: Z >--> BigInt =
    functionWithInfo("one")(oneFunction)  

  def pointfulLogWritingFactorial: BigInt >--> BigInt =
    withInfo("factorial") {
      `if`(isPositive) {
        `let` {
          subtractOne >-->
            pointfulLogWritingFactorial  
        } `in`
          multiply
      } `else` {
        one
      } 
    }

  val pointfulLogWritingFactorialProgram: Unit >--> Unit =
    producer >-->
      pointfulLogWritingFactorial >-->
      consumer

  def executePointfulLogWritingFactorialProgram: Unit =
    execute(pointfulLogWritingFactorialProgram)     

}
