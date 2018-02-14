package pdbp.program.instances.active.writing.log.sl4j.free

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

import pdbp.types.active.free.activeFreeTypes._

import pdbp.types.active.writing.free.log.activeLogWritingWithFreeTypes._

import pdbp.program.writing.Writing

import pdbp.program.writing.log.sl4j.LogWritingUsingSl4j

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.computation.transformer.writing.WritingTransformer

import pdbp.program.instances.active.writing.free.ActiveWritingWithFreeProgram

import pdbp.program.writing.folding.implicits.log.implicits.implicitLogFolding

import pdbp.program.implicits.active.free.implicits.implicitActiveFreeProgram

trait ActiveLogWritingUsingSl4jWithFreeProgram
    extends ActiveWritingWithFreeProgram[Log]
    with LogWritingUsingSl4j[`>-alwf->`] {

  import implicitComputation.{result => resultM}
  import implicitComputation.{bind => bindM}

  import implicitProgram.{execute => executeK}

  override def execute(`u>-alwf->u`: Unit `>-alwf->` Unit): Environment `I=>` Unit = {
    executeK { u: Unit =>
      bindM(`u>-alwf->u`(u), { (log, u) =>
        log.effect(())
        resultM(u)
      })
    } 
  }        

}

object activeLogWritingUsingSl4jWithFreeProgram
    extends ActiveLogWritingUsingSl4jWithFreeProgram
    with ActiveWritingWithFreeProgram[Log]()
    with Writing[Log, `>-alwf->`]() 
    with ComputationTransformer[ActiveFree, ActiveLogWritingWithFree]()
    with ProgramTransformer[`>-af->`, `>-alwf->`]()
    with WritingTransformer[Log, ActiveFree]()
