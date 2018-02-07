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

import pdbp.types.active.activeTypes._

import pdbp.types.active.reading.int.activeIntReadingTypes._

import pdbp.program.reading.int.console.IntReadingFromConsole

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.computation.transformer.reading.ReadingTransformer

import pdbp.program.instances.active.reading.ActiveReadingProgram

import pdbp.program.implicits.active.implicits.implicitActiveProgram

trait ActiveIntReadingFromConsoleProgram
    extends ActiveReadingProgram[BigInt]
    with IntReadingFromConsole[`>-air->`] {

  implicit val implicitIntReadFromConsole: BigInt = 
    readIntFromConsole(())

  private val environmentK = implicitProgram.environment

  override implicit val environment: Environment = {
    (environmentK, implicitIntReadFromConsole)
  }

}

object activeIntReadingFromConsoleProgram
    extends ActiveIntReadingFromConsoleProgram()
    with ComputationTransformer[Active, ActiveIntReading]()
    with ProgramTransformer[`>-a->`, `>-air->`]()
    with ReadingTransformer[BigInt, Active]()

    