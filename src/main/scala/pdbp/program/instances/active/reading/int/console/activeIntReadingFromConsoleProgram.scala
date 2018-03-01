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

import pdbp.program.reading.int.IntReading

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.NaturalTransformation

import pdbp.computation.transformation.NaturalComputationTransformation

import pdbp.computation.transformation.reading.ReadingTransformation

import pdbp.computation.transformation.reading.int.IntReadingTransformation

import pdbp.computation.transformation.reading.int.console.ImplicitIntReadingFromConsoleTransformation

import pdbp.program.instances.active.reading.ActiveReadingProgram

import pdbp.program.implicits.active.implicits.implicitActiveProgram

trait ActiveIntReadingFromConsoleProgram
    extends ActiveReadingProgram[BigInt]
    with IntReading[`>-air->`]
    with ImplicitIntReadingFromConsoleTransformation[Active] 

object activeIntReadingFromConsoleProgram
    extends ActiveIntReadingFromConsoleProgram()
    with NaturalTransformation[Active, ActiveIntReading]()
    with NaturalComputationTransformation[Active, ActiveIntReading]()
    with ProgramTransformation[`>-a->`, `>-air->`]()
    with ReadingTransformation[BigInt, Active]()
    with IntReadingTransformation[Active]()
    with ImplicitIntReadingFromConsoleTransformation[Active]()
    

    