package pdbp.program.instances.active.reading.int

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.computation.transformer.reading.ReadingTransformer

import pdbp.types.active.activeTypes._

import pdbp.program.implicits.active.implicits.implicitActiveProgram

import pdbp.types.active.reading.int.activeIntReadingTypes._

import pdbp.program.instances.active.reading.ActiveReadingProgram

object activeIntReadingProgram
    extends ActiveReadingProgram[Int]
    with ReadingTransformer[Int, Active]()
    with ComputationTransformer[Active, ActiveIntReading]()
    with Computation[ActiveIntReading]
    with ProgramTransformer[`>-a->`, `>-air->`]()
    with Program[`>-air->`] {


}
