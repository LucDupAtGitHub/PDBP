package pdbp.program.instances.active.reading.writing

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

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

import pdbp.program.Program

import pdbp.program.writing.folding.Folding

import pdbp.computation.Computation

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.ComputationTransformation

import pdbp.computation.transformation.reading.writing.ReadingWithWritingTransformation

trait ActiveReadingWithWritingProgram[R, W : Folding]
    extends Computation[ActiveReadingWithWriting[R, W]]
    with Program[`>-arw->`[R, W]]
    with ComputationTransformation[ActiveWriting[W], ActiveReadingWithWriting[R, W]]
    with ProgramTransformation[`>-aw->`[W], `>-arw->`[R, W]]
    with ReadingWithWritingTransformation[R, W, ActiveWriting[W]]
