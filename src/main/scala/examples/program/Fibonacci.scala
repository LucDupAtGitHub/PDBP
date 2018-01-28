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

trait FibonacciTrait[>-->[- _, + _]: Program] {

  val implicitProgram = implicitly[Program[>-->]]

  import implicitProgram._

  import pdbp.program.compositionOperator._
  import pdbp.program.constructionOperators._

  import pdbp.utils.productUtils._

  import examples.utils.functionUtils._  

  lazy val fibonacci: BigInt >--> BigInt =
    `if`(isZero) {
      zero
    } `else` {
      `if`(isOne) {
        one
      } `else` {
        (subtractOne & subtractTwo) >-->
          (fibonacci && fibonacci) >-->
          add
      }
    }

  val isZero: BigInt >--> Boolean =
    function(isZeroFunction)

  def zero[Z]: Z >--> BigInt =
    function(zeroFunction)

  val isOne: BigInt >--> Boolean =
    function(isOneFunction)

  def one[Z]: Z >--> BigInt =
    function(oneFunction)

  val subtractOne: BigInt >--> BigInt =
    function(subtractOneFunction)

  val subtractTwo: BigInt >--> BigInt =
    function(subtractTwoFunction)

  val add: (BigInt && BigInt) >--> BigInt =
    function(addFunction)  

  lazy val letAndInFibonacci: BigInt >--> BigInt =
    `if`(isZero) {
      zero
    } `else` {
      `if`(isOne) {
        one
      } `else` {
        `let` {
          subtractOne >-->
            letAndInFibonacci
        } `in` {
          val i: (BigInt && BigInt) >--> BigInt =
            `(z&&y)>-->z`
          `let` {
            i >-->
              subtractTwo >-->
              letAndInFibonacci
          } `in` {
            val `fibonacci(i-1)&&fibonacci(i-2)`
              : ((BigInt && BigInt) && BigInt) >--> (BigInt && BigInt) =
              `((z&&y)&&x)>-->(y&&x)`
            `fibonacci(i-1)&&fibonacci(i-2)` >-->
              add
          }
        }
      }
    }

  val optimizedFibonacci =
    `let` {
      (zero & one)
    } `in` {
      lazy val optimizedFibonacciHelper
        : (BigInt && (BigInt && BigInt)) >--> BigInt = {
        val argument: (BigInt && (BigInt && BigInt)) >--> BigInt =
          `(z&&(y&&x))>-->z`
        val current: (BigInt && (BigInt && BigInt)) >--> BigInt =
          `(z&&(y&&x))>-->y`
        val next: (BigInt && (BigInt && BigInt)) >--> BigInt =
          `(z&&(y&&x))>-->x`
        `if`(argument >--> isZero) {
          current
        } `else` {
          `if`(argument >--> isOne) {
            next
          } `else` {
            val current: (BigInt && BigInt) >--> BigInt =
              `(z&&y)>-->y`
            val next =
              add
            (subtractOne && (current & next)) >-->
              optimizedFibonacciHelper
          }
        }
      }
      optimizedFibonacciHelper
    }

  val producer: Unit >--> BigInt =
    readInt("please type an integer")

  val consumer: BigInt >--> Unit =
    write(s"it's fibonacci value is")

  val fibonacciProgram: Unit >--> Unit =
    producer >-->
      optimizedFibonacci >-->
      consumer

  def executeFibonacciProgram: Unit =
    execute(fibonacciProgram)       

}
