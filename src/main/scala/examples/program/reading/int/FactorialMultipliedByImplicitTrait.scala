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

trait FactorialMultipliedByImplicitTrait[>-->[- _, + _]: Program : [>-->[- _, + _]] => Reading[BigInt, >-->]] 
  extends examples.program.FactorialTrait[>-->] {

  import implicitProgram._

  val implicitReading = implicitly[Reading[BigInt, >-->]]

  import implicitReading._

  import pdbp.program.compositionOperator._
  import pdbp.program.constructionOperators._

  def implicitlyConsumedInt[Z]: Z >--> BigInt = `z>-->r`
      
  lazy val factorialMultipliedByImplicit: BigInt >--> BigInt = (factorial & implicitlyConsumedInt) >--> multiply

  override val consumer: BigInt >--> Unit =
    write(s"the factorial value of the integer multiplied by the integer configured by reading from the console is")

  val factorialMultipliedByImplicitProgram: Unit >--> Unit =
    producer >-->
      factorialMultipliedByImplicit >-->
      consumer

  def executeFactorialMultipliedByImplicitProgram: Unit =
    execute(factorialMultipliedByImplicitProgram)        
   
}
