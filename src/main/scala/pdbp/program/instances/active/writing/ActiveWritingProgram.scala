package pdbp.program.instances.active.writing

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

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.NaturalComputationTransformation

import pdbp.computation.transformation.writing.WritingTransformation

import pdbp.program.implicits.active.implicits.implicitActiveProgram

trait ActiveWritingProgram[W]
    extends Computation[ActiveWriting[W]]
    with Program[`>-aw->`[W]]
    with ProgramTransformation[`>-a->`, `>-aw->`[W]]
    with NaturalComputationTransformation[Active, ActiveWriting[W]]
    with WritingTransformation[W, Active]

