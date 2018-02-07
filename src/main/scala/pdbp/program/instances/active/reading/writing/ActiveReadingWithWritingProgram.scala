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

import pdbp.program.writing.folding.Folding

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.computation.transformer.reading.writing.ReadingWithWritingTransformer

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

trait ActiveReadingWithWritingProgram[R, W : Folding]
    extends Computation[ActiveReadingWithWriting[R, W]]
    with Program[`>-arw->`[R, W]]
    with ComputationTransformer[ActiveWriting[W], ActiveReadingWithWriting[R, W]]
    with ProgramTransformer[`>-aw->`[W], `>-arw->`[R, W]]
    with ReadingWithWritingTransformer[R, W, ActiveWriting[W]]
