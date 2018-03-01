package pdbp.program.instances.active.reading.int.console.writing.log.sl4j

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

// import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.types.log.logTypes._

import pdbp.types.active.activeTypes._

import pdbp.types.active.writing.log.activeLogWritingTypes._

import pdbp.types.active.reading.int.activeIntReadingTypes._

import pdbp.types.active.reading.int.writing.log.activeIntReadingWithLogWritingTypes._

import pdbp.program.Program

import pdbp.program.reading.int.IntReading

import pdbp.program.writing.Writing

import pdbp.program.writing.log.sl4j.LogWritingUsingSl4j

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.NaturalTransformer

import pdbp.computation.transformer.NaturalComputationTransformer

import pdbp.computation.transformer.reading.ReadingTransformer

import pdbp.computation.transformer.reading.int.IntReadingTransformer

import pdbp.computation.transformer.reading.int.console.ImplicitIntReadingFromConsoleTransformer

import pdbp.computation.transformer.reading.writing.ReadingWithWritingTransformer

import pdbp.computation.transformer.reading.writing.log.ReadingWithLogWritingTransformer

import pdbp.program.instances.active.reading.writing.ActiveReadingWithWritingProgram

import pdbp.program.instances.active.reading.writing.log.ActiveReadingWithLogWritingProgram

import pdbp.program.writing.folding.implicits.log.implicits.implicitLogFolding

import pdbp.program.implicits.active.writing.log.sl4j.implicits.implicitActiveLogWritingUsingSl4jProgram

trait ActiveIntReadingFromConsoleWithLogWritingUsingSl4jProgram
    extends ActiveReadingWithLogWritingProgram[BigInt] 
    with IntReading[`>-airlw->`]
    with LogWritingUsingSl4j[`>-airlw->`] 
    with ImplicitIntReadingFromConsoleTransformer[ActiveLogWriting] 

object activeIntReadingFromConsoleWithLogWritingUsingSl4jProgram
    extends ActiveIntReadingFromConsoleWithLogWritingUsingSl4jProgram 
    with ActiveReadingWithWritingProgram[BigInt, Log]()
    with Writing[Log, `>-airlw->`]() 
    with NaturalTransformer[ActiveLogWriting, ActiveIntReadingWithLogWriting]()
    with NaturalComputationTransformer[ActiveLogWriting, ActiveIntReadingWithLogWriting]()
    with ProgramTransformer[`>-alw->`, `>-airlw->`]() 
    with ReadingTransformer[BigInt, ActiveLogWriting]() 
    with IntReadingTransformer[ActiveLogWriting]()
    with ReadingWithWritingTransformer[BigInt, Log, ActiveLogWriting]() 
    with ReadingWithLogWritingTransformer[BigInt, ActiveLogWriting]() 
    with ImplicitIntReadingFromConsoleTransformer[ActiveLogWriting]()