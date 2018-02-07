package pdbp.program.instances.active.reading.int.console

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

// import pdbp.utils.runUtils._

import pdbp.program.Program

import pdbp.program.reading.int.console.IntReadingFromConsole

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.computation.transformer.reading.ReadingTransformer

import pdbp.types.active.activeTypes._

import pdbp.program.implicits.active.implicits.implicitActiveProgram

import pdbp.types.active.reading.int.activeIntReadingTypes._

import pdbp.program.instances.active.reading.ActiveReadingProgram

// object activeIntReadingFromConsoleProgram
//     extends Computation[ActiveIntReading]
//     with Program[`>-air->`]
//     with ActiveReadingProgram[BigInt]
//     with ComputationTransformer[Active, ActiveIntReading]()
//     with ProgramTransformer[`>-a->`, `>-air->`]()
//     with ReadingTransformer[BigInt, Active]() {

//   implicit val implicitIntReadFromConsole: BigInt = 
//     readInt("please type an integer to read")(())

//   import implicitProgram.{environment => environmentK}

//   override implicit val environment: Environment = {
//     (environmentK, implicitIntReadFromConsole)
//   }

// }

trait ActiveIntReadingFromConsoleProgram
    extends Computation[ActiveIntReading]
    with Program[`>-air->`]
    with ActiveReadingProgram[BigInt]
    with ComputationTransformer[Active, ActiveIntReading]
    with ProgramTransformer[`>-a->`, `>-air->`]
    with ReadingTransformer[BigInt, Active] 
    with IntReadingFromConsole[`>-air->`] {

  implicit val implicitIntReadFromConsole: BigInt = 
    intReadFromConsole(())
    // readInt("please type an integer to read")(())

  // not better
  // private val implicitProgram = implicitly[Program[`>-air->`]]

  // leads to trouble
  // import implicitProgram.{environment => environmentK}

  override implicit val environment: Environment = {
    (implicitProgram.environment, implicitIntReadFromConsole)
  }

}

object activeIntReadingFromConsoleProgram
    extends ActiveIntReadingFromConsoleProgram()
    with ComputationTransformer[Active, ActiveIntReading]()
    with ProgramTransformer[`>-a->`, `>-air->`]()
    with ReadingTransformer[BigInt, Active]()

    