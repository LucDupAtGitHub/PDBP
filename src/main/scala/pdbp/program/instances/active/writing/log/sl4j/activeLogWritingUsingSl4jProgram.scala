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

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.writing.WritingTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.program.instances.active.writing.ActiveWritingProgram

import pdbp.program.implicits.active.implicits.implicitActiveProgram

import pdbp.program.writing.folding.implicits.log.implicits.implicitLogFolding

trait ActiveLogWritingUsingSl4jProgram
    extends ActiveWritingProgram[Log]
    with LogWritingUsingSl4j[`>-alw->`] {   
  
  import implicitComputation.{result => resultM}
  import implicitComputation.{bind => bindM}

  import implicitProgram.{execute => executeK}

  override def execute(`u>-alw->u`: Unit `>-alw->` Unit): Environment `I=>` Unit = {
    executeK { u: Unit =>
      bindM(`u>-alw->u`(u), { (log, u) =>
        log.effect(())
        resultM(u)
      })
    } 
  }

}

object activeLogWritingUsingSl4jProgram
    extends ActiveLogWritingUsingSl4jProgram
    with Writing[Log, `>-alw->`]()
    with ComputationTransformer[Active, ActiveLogWriting]()
    with ProgramTransformer[`>-a->`, `>-alw->`]()
    with WritingTransformer[Log, Active]()

