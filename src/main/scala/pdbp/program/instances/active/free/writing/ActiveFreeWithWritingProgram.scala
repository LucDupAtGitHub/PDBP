package pdbp.program.instances.active.free.writing

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.types.active.free.writing.activeFreeWithWritingTypes._

import pdbp.utils.productUtils._

import pdbp.program.writing.folding.Folding

import pdbp.program.Program

import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.NaturalComputationTransformation

import pdbp.computation.transformation.free.FreeTransformation

import pdbp.computation.transformation.free.freeTransformation._

import pdbp.computation.transformation.free.writing.FreeWithWritingTransformation

trait ActiveFreeWithWritingProgram[W : Folding]
    extends Computation[ActiveFreeWithWriting[W]]
    with Program[`>-afw->`[W]]
    with NaturalComputationTransformation[ActiveWriting[W], ActiveFreeWithWriting[W]]
    with ProgramTransformation[`>-aw->`[W], `>-afw->`[W]]
    with FreeWithWritingTransformation[W, ActiveWriting[W]]
