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

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.NaturalTransformation

import pdbp.computation.transformation.NaturalComputationTransformation

import pdbp.computation.transformation.writing.WritingTransformation

import pdbp.computation.transformation.writing.log.LogWritingTransformation

import pdbp.computation.transformation.writing.log.sl4j.LogWritingUsingSl4jTransformation

import pdbp.program.instances.active.writing.free.ActiveWritingWithFreeProgram

import pdbp.program.writing.folding.implicits.log.implicits.implicitLogFolding

import pdbp.program.implicits.active.free.implicits.implicitActiveFreeProgram

trait ActiveLogWritingUsingSl4jFreeProgram
    extends ActiveWritingWithFreeProgram[Log]
    with LogWritingUsingSl4j[`>-alwf->`] 
    with LogWritingUsingSl4jTransformation[ActiveFree] {   

  import pdbp.utils.productUtils._

  import pdbp.types.implicitFunctionType.`I=>`

  import pdbp.types.active.activeTypes._

  import pdbp.types.active.writing.activeWritingTypes._ 

  import pdbp.types.active.writing.log.activeLogWritingTypes._

  import pdbp.computation.transformation.writing.writingTransformation._

  import pdbp.computation.transformation.free.freeTransformation._

  import pdbp.program.instances.active.free.activeFreeProgram

  import pdbp.program.instances.active.writing.log.sl4j.activeLogWritingUsingSl4jProgram  
  
  private type LWTAF = WritingTransformed[Log, ActiveFree]

  private type LWTA = WritingTransformed[Log, Active]

  import implicitProgram.{Environment => EnvironmentK}

  override val environment: Environment = implicitProgram.environment

  override def execute(`u>-alwf->u`: Unit `>-alwf->` Unit): Environment `I=>` Unit =
    activeLogWritingUsingSl4jProgram.execute(recuperateProgram(`u>-alwf->u`)) 

  private final def recuperateComputation[Z](lwtafz: LWTAF[Z]): LWTA[Z] = 
    activeFreeProgram.recuperateComputation(lwtafz)
   
  private[pdbp] def recuperateProgram[Z, Y](
      `z>-alwf->y`: Z `>-alwf->` Y): Z `>-alw->` Y = { z =>
    recuperateComputation(`z>-alwf->y`(z))
  }            

}

object activeLogWritingUsingSl4jFreeProgram
    extends ActiveLogWritingUsingSl4jFreeProgram
    with ActiveWritingWithFreeProgram[Log]()
    with Writing[Log, `>-alwf->`]() 
    with NaturalTransformation[ActiveFree, ActiveLogWritingWithFree]()
    with NaturalComputationTransformation[ActiveFree, ActiveLogWritingWithFree]()
    with ProgramTransformation[`>-af->`, `>-alwf->`]()
    with WritingTransformation[Log, ActiveFree]()
    with LogWritingTransformation[ActiveFree]()
    with LogWritingUsingSl4jTransformation[ActiveFree]()