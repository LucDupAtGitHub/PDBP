package examples.program

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

import pdbp.program.Program

trait FactorialTrait[>-->[- _, + _]: Program] {

  val implicitProgram = implicitly[Program[>-->]]

  import implicitProgram._

  import pdbp.program.compositionOperator._

  import pdbp.utils.productUtils._

  import examples.utils.functionUtils._

  val isPositive: BigInt >--> Boolean =
    function(isPositiveFunction)

  val subtractOne: BigInt >--> BigInt =
    function(subtractOneFunction)

  val multiply: (BigInt && BigInt) >--> BigInt =
    function(multiplyFunction)

  def one[Z]: Z >--> BigInt =
    function(oneFunction)

  lazy val factorial: BigInt >--> BigInt =
    `if`(isPositive) {
      `let` {
        subtractOne >-->
          factorial
      } `in`
        multiply
    } `else` {
      one
    }

  lazy val pointfulFactorial: BigInt >--> BigInt = {
    val i: BigInt >--> BigInt =
      `z>-->z`
    `if`(i >--> isPositive) {
      `let` {
        i >-->
          subtractOne >-->
          pointfulFactorial
      } `in` {
        val `i&&factorial(i-1)` : (BigInt && BigInt) >--> (BigInt && BigInt) =
          `z>-->z`
        `i&&factorial(i-1)` >-->
          multiply
      }
    } `else` {
      i >-->
        one
    }
  }

  val `_ > 0`: BigInt >--> Boolean =
    function(isPositiveFunction)

  val `_ - 1`: BigInt >--> BigInt =
    function(subtractOneFunction)

  val `_ * _` : (BigInt && BigInt) >--> BigInt =
    function(multiplyFunction)

  def `1`[Z]: Z >--> BigInt =
    function(oneFunction)

  lazy val backtickFactorial: BigInt >--> BigInt =
    `if`(`_ > 0`) {
      `let` {
        `_ - 1` >-->
          backtickFactorial
      } `in`
        `_ * _`
    } `else` {
      `1`
    }

  import pdbp.program.constructionOperators._

  lazy val productFactorial: BigInt >--> BigInt =
    `if`(isPositive) {
      val i: BigInt >--> BigInt =
        `z>-->z`
      (i & subtractOne >--> productFactorial) >-->
        multiply
    } `else` {
      one
    }

  val producer: Unit >--> BigInt =
    readInt("please type an integer")

  val consumer: BigInt >--> Unit =
    write(s"it's factorial value is")

  val factorialProgram: Unit >--> Unit =
    producer >-->
      factorial >-->
      consumer

  def executeFactorialProgram: Unit =
    execute(factorialProgram)   

}
