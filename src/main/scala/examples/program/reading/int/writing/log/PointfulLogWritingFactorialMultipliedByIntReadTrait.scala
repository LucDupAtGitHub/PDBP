package examples.program.reading.int.writing.log

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

import pdbp.program.reading.Reading

import pdbp.program.writing.Writing

import pdbp.program.writing.log.LogWriting

import examples.program.writing.log.PointfulLogWritingFactorialTrait

import examples.program.reading.int.FactorialMultipliedByIntReadTrait

trait PointfulLogWritingFactorialMultipliedByIntReadTrait
  [>-->[- _, + _]: Program : [>-->[- _, + _]] => Reading[BigInt, >-->] : [>-->[- _, + _]] => LogWriting[>-->]]
    extends FactorialMultipliedByIntReadTrait[>-->] 
    with PointfulLogWritingFactorialTrait[>-->] {

  import implicitProgram._

  import implicitReading._

  import implicitReading._

  import pdbp.program.compositionOperator._
  import pdbp.program.constructionOperators._

  lazy val pointfulLogWritingFactorialMultipliedByIntRead
    : BigInt >--> BigInt = (pointfulLogWritingFactorial & readingInt) >--> multiply

  val pointfulLogWritingFactorialMultipliedByIntReadProgram: Unit >--> Unit =
    producer >-->
      pointfulLogWritingFactorialMultipliedByIntRead >-->
      consumer

  def executePointfulLogWritingFactorialMultipliedByIntReadProgram: Unit =
    execute(pointfulLogWritingFactorialMultipliedByIntReadProgram)

}
