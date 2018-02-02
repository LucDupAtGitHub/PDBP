package examples.program.reading.int

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

import pdbp.program.reading.Reading

import examples.program.FactorialTrait

trait FactorialMultipliedByIntReadTrait
  [>-->[- _, + _]: Program : [>-->[- _, + _]] => Reading[BigInt, >-->]]
    extends FactorialTrait[>-->] {

  import implicitProgram._

  val implicitReading = implicitly[Reading[BigInt, >-->]]

  import implicitReading._

  import pdbp.program.compositionOperator._
  import pdbp.program.constructionOperators._

  def readingInt[Z]: Z >--> BigInt = reading

  lazy val factorialMultipliedByIntRead
    : BigInt >--> BigInt = (factorial & readingInt) >--> multiply

  override val consumer: BigInt >--> Unit =
    write(
      s"the factorial value of the integer multiplied by the integer read is")

  val factorialMultipliedByIntReadProgram: Unit >--> Unit =
    producer >-->
      factorialMultipliedByIntRead >-->
      consumer

  def executeFactorialMultipliedByIntReadProgram: Unit =
    execute(factorialMultipliedByIntReadProgram)

}
