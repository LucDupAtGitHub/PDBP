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

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.NaturalTransformer

import pdbp.computation.transformer.NaturalComputationTransformer

import pdbp.computation.transformer.reading.ReadingTransformer

import pdbp.computation.transformer.reading.int.IntReadingTransformer

import pdbp.computation.transformer.reading.int.console.ImplicitIntReadingFromConsoleTransformer

import pdbp.program.instances.active.reading.ActiveReadingProgram

import pdbp.program.implicits.active.implicits.implicitActiveProgram

trait ActiveIntReadingFromConsoleProgram
    extends ActiveReadingProgram[BigInt]
    with IntReading[`>-air->`]
    with ImplicitIntReadingFromConsoleTransformer[Active] 

object activeIntReadingFromConsoleProgram
    extends ActiveIntReadingFromConsoleProgram()
    with NaturalTransformer[Active, ActiveIntReading]()
    with NaturalComputationTransformer[Active, ActiveIntReading]()
    with ProgramTransformer[`>-a->`, `>-air->`]()
    with ReadingTransformer[BigInt, Active]()
    with IntReadingTransformer[Active]()
    with ImplicitIntReadingFromConsoleTransformer[Active]()
    

    