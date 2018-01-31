package pdbp.program.instances.active.reading

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

import pdbp.types.active.reading.activeReadingTypes._

trait ActiveReadingProgram[R]
    extends ReadingTransformer[R, Active]
    with ComputationTransformer[Active, ActiveReading[R]]
    with Computation[ActiveReading[R]]
    with ProgramTransformer[`>-a->`, `>-ar->`[R]]
    with Program[`>-ar->`[R]] {


}

