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

import examples.program.writing.log.PointfreeLogWritingFactorialTrait

import examples.program.reading.int.FactorialMultipliedByIntReadTrait

trait PointfreeLogWritingFactorialMultipliedByIntReadTrait
  [>-->[- _, + _]: Program : [>-->[- _, + _]] => Reading[BigInt, >-->] : [>-->[- _, + _]] => LogWriting[>-->]]
    extends FactorialMultipliedByIntReadTrait[>-->] 
    with PointfreeLogWritingFactorialTrait[>-->] {

  import implicitProgram._

  import implicitReading._

  import implicitReading._

  import pdbp.program.compositionOperator._
  import pdbp.program.constructionOperators._

  lazy val pointfreeLogWritingFactorialMultipliedByIntRead
    : BigInt >--> BigInt = (pointfreeLogWritingFactorial & readingInt) >--> multiply

  val pointfreeLogWritingFactorialMultipliedByIntReadProgram: Unit >--> Unit =
    producer >-->
      pointfreeLogWritingFactorialMultipliedByIntRead >-->
      consumer

  def executePointfreeLogWritingFactorialMultipliedByIntReadProgram: Unit =
    execute(pointfreeLogWritingFactorialMultipliedByIntReadProgram)

}
