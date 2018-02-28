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

import pdbp.types.active.writing.log.free.activeLogWritingWithFreeTypes._

import pdbp.program.writing.Writing

import pdbp.program.writing.log.sl4j.LogWritingUsingSl4j

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.NaturalTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.computation.transformer.writing.WritingTransformer

import pdbp.computation.transformer.writing.log.LogWritingTransformer

import pdbp.computation.transformer.writing.log.sl4j.LogWritingUsingSl4jTransformer

import pdbp.program.instances.active.writing.free.ActiveWritingWithFreeProgram

import pdbp.program.writing.folding.implicits.log.implicits.implicitLogFolding

import pdbp.program.implicits.active.free.implicits.implicitActiveFreeProgram

trait ActiveLogWritingUsingSl4jFreeProgram
    extends ActiveWritingWithFreeProgram[Log]
    with LogWritingUsingSl4j[`>-alwf->`] 
    with LogWritingUsingSl4jTransformer[ActiveFree] {   

  import pdbp.utils.productUtils._

  import pdbp.types.implicitFunctionType.`I=>`

  import pdbp.types.active.activeTypes._

  import pdbp.types.active.writing.activeWritingTypes._ 

  import pdbp.types.active.writing.log.activeLogWritingTypes._

  import pdbp.computation.transformer.writing.writingTransformer._

  import pdbp.computation.transformer.free.freeTransformer._

  import pdbp.program.instances.active.free.activeFreeProgram

  import pdbp.program.instances.active.writing.log.sl4j.activeLogWritingUsingSl4jProgram  
  
  private type LWTAF = WritingTransformed[Log, ActiveFree]

  private type LWTA = WritingTransformed[Log, Active]

  import implicitProgram.{Environment => EnvironmentK}

  override val environment: Environment = implicitProgram.environment

  override def execute(`u>-alwf->u`: Unit `>-alwf->` Unit): Environment `I=>` Unit =
    activeLogWritingUsingSl4jProgram.execute(lowerProgram(`u>-alwf->u`)) 

  private final def lowerComputation[Z](lwtafz: LWTAF[Z]): LWTA[Z] = 
    activeFreeProgram.lowerComputation(lwtafz)
   
  private[pdbp] def lowerProgram[Z, Y](
      `z>-alwf->y`: Z `>-alwf->` Y): Z `>-alw->` Y = { z =>
    lowerComputation(`z>-alwf->y`(z))
  }            

}

object activeLogWritingUsingSl4jFreeProgram
    extends ActiveLogWritingUsingSl4jFreeProgram
    with ActiveWritingWithFreeProgram[Log]()
    with Writing[Log, `>-alwf->`]() 
    with NaturalTransformer[ActiveFree, ActiveLogWritingWithFree]()
    with ComputationTransformer[ActiveFree, ActiveLogWritingWithFree]()
    with ProgramTransformer[`>-af->`, `>-alwf->`]()
    with WritingTransformer[Log, ActiveFree]()
    with LogWritingTransformer[ActiveFree]()
    with LogWritingUsingSl4jTransformer[ActiveFree]()