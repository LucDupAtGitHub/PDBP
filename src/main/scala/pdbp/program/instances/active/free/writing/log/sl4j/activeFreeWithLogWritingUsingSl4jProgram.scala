package pdbp.program.instances.active.free.writing.log.sl4j

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.types.implicitFunctionType.`I=>`

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.types.log.logTypes._

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.types.active.writing.log.activeLogWritingTypes._

import pdbp.types.active.free.writing.activeFreeWithWritingTypes._

import pdbp.types.active.free.writing.log.activeFreeWithLogWritingTypes._

import pdbp.utils.productUtils._

import pdbp.program.Program

import pdbp.program.writing.Writing

import pdbp.program.writing.log.sl4j.LogWritingUsingSl4j

import pdbp.program.writing.folding.Folding

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.NaturalComputationTransformer

import pdbp.computation.transformer.free.writing.FreeWithWritingTransformer

import pdbp.computation.transformer.free.writing.log.FreeWithLogWritingTransformer

import pdbp.computation.transformer.free.FreeTransformer

import pdbp.computation.transformer.free.freeTransformer._

import pdbp.program.instances.active.writing.log.sl4j.activeLogWritingUsingSl4jProgram

import pdbp.program.instances.active.free.writing.ActiveFreeWithWritingProgram

import pdbp.program.instances.active.free.writing.log.ActiveFreeWithLogWritingProgram

import pdbp.program.writing.folding.implicits.log.implicits.implicitLogFolding

import pdbp.program.implicits.active.writing.log.sl4j.implicits.implicitActiveLogWritingUsingSl4jProgram

trait ActiveFreeWithLogWritingUsingSl4jProgram
    extends ActiveFreeWithLogWritingProgram
    with LogWritingUsingSl4j[`>-aflw->`]

    
object activeFreeWithLogWritingUsingSl4jProgram
    extends ActiveFreeWithLogWritingUsingSl4jProgram
    with ActiveFreeWithWritingProgram[Log]()
    with ProgramTransformer[`>-alw->`, `>-afw->`[Log]]()
    with NaturalComputationTransformer[ActiveLogWriting, ActiveFreeWithLogWriting]()
    with FreeWithLogWritingTransformer[ActiveLogWriting]()
    with FreeWithWritingTransformer[Log, ActiveLogWriting]()
    with FreeTransformer[ActiveLogWriting]()
    with LogWritingUsingSl4j[Kleisli[ActiveFreeWithLogWriting]]()
    with Writing[Log, Kleisli[ActiveFreeWithLogWriting]]()
