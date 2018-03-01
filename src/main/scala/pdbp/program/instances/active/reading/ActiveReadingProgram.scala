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

import pdbp.types.active.activeTypes._

import pdbp.types.active.reading.activeReadingTypes._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.NaturalComputationTransformation

import pdbp.computation.transformation.reading.ReadingTransformation

import pdbp.program.implicits.active.implicits.implicitActiveProgram

trait ActiveReadingProgram[R]
    extends Computation[ActiveReading[R]]
    with Program[`>-ar->`[R]]
    with NaturalComputationTransformation[Active, ActiveReading[R]]
    with ProgramTransformation[`>-a->`, `>-ar->`[R]]
    with ReadingTransformation[R, Active]

