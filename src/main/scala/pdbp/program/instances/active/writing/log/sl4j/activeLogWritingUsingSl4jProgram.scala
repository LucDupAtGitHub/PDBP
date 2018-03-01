package pdbp.program.instances.active.writing.log.sl4j

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

import pdbp.types.implicitFunctionType.`I=>`

import pdbp.types.log.logTypes._

import pdbp.types.active.activeTypes._

import pdbp.types.active.writing.log.activeLogWritingTypes._

import pdbp.program.writing.Writing

import pdbp.program.writing.log.sl4j.LogWritingUsingSl4j

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.NaturalTransformation

import pdbp.computation.transformation.NaturalComputationTransformation

import pdbp.computation.transformation.writing.WritingTransformation

import pdbp.computation.transformation.writing.log.LogWritingTransformation

import pdbp.computation.transformation.writing.log.sl4j.LogWritingUsingSl4jTransformation

import pdbp.program.instances.active.writing.ActiveWritingProgram

import pdbp.program.implicits.active.implicits.implicitActiveProgram

import pdbp.program.writing.folding.implicits.log.implicits.implicitLogFolding

trait ActiveLogWritingUsingSl4jProgram
    extends ActiveWritingProgram[Log]
    with LogWritingUsingSl4j[`>-alw->`] 
    with LogWritingUsingSl4jTransformation[Active] {

}

object activeLogWritingUsingSl4jProgram
    extends ActiveLogWritingUsingSl4jProgram
    with Writing[Log, `>-alw->`]()
    with NaturalTransformation[Active, ActiveLogWriting]()
    with NaturalComputationTransformation[Active, ActiveLogWriting]()
    with ProgramTransformation[`>-a->`, `>-alw->`]()
    with WritingTransformation[Log, Active]()
    with LogWritingTransformation[Active]()
    with LogWritingUsingSl4jTransformation[Active]()

