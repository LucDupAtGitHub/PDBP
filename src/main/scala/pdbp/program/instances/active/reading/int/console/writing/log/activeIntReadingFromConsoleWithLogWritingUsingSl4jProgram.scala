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

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.NaturalTransformation

import pdbp.computation.transformation.ComputationTransformation

import pdbp.computation.transformation.reading.ReadingTransformation

import pdbp.computation.transformation.reading.int.IntReadingTransformation

import pdbp.computation.transformation.reading.int.console.ImplicitIntReadingFromConsoleTransformation

import pdbp.computation.transformation.reading.writing.ReadingWithWritingTransformation

import pdbp.computation.transformation.reading.writing.log.ReadingWithLogWritingTransformation

import pdbp.program.instances.active.reading.writing.ActiveReadingWithWritingProgram

import pdbp.program.instances.active.reading.writing.log.ActiveReadingWithLogWritingProgram

import pdbp.program.writing.folding.implicits.log.implicits.implicitLogFolding

import pdbp.program.implicits.active.writing.log.sl4j.implicits.implicitActiveLogWritingUsingSl4jProgram

trait ActiveIntReadingFromConsoleWithLogWritingUsingSl4jProgram
    extends ActiveReadingWithLogWritingProgram[BigInt] 
    with IntReading[`>-airlw->`]
    with LogWritingUsingSl4j[`>-airlw->`] 
    with ImplicitIntReadingFromConsoleTransformation[ActiveLogWriting] 

object activeIntReadingFromConsoleWithLogWritingUsingSl4jProgram
    extends ActiveIntReadingFromConsoleWithLogWritingUsingSl4jProgram 
    with ActiveReadingWithWritingProgram[BigInt, Log]()
    with Writing[Log, `>-airlw->`]() 
    with NaturalTransformation[ActiveLogWriting, ActiveIntReadingWithLogWriting]()
    with ComputationTransformation[ActiveLogWriting, ActiveIntReadingWithLogWriting]()
    with ProgramTransformation[`>-alw->`, `>-airlw->`]() 
    with ReadingTransformation[BigInt, ActiveLogWriting]() 
    with IntReadingTransformation[ActiveLogWriting]()
    with ReadingWithWritingTransformation[BigInt, Log, ActiveLogWriting]() 
    with ReadingWithLogWritingTransformation[BigInt, ActiveLogWriting]() 
    with ImplicitIntReadingFromConsoleTransformation[ActiveLogWriting]()