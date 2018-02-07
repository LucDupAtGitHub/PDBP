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

import org.slf4j.LoggerFactory

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.program.writing.Writing

import pdbp.program.writing.log.LogWriting

import pdbp.program.writing.log.sl4j.LogWritingUsingSl4j

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.computation.transformer.writing.WritingTransformer

import pdbp.types.active.activeTypes._

import pdbp.program.implicits.active.implicits.implicitActiveProgram

import pdbp.types.active.writing.log.activeLogWritingTypes._

import pdbp.program.instances.active.writing.ActiveWritingProgram

import pdbp.program.writing.folding.implicits.log.implicits.implicitLogFolding

trait ActiveLogWritingUsingSl4jProgram
    extends Computation[ActiveLogWriting]
    with Program[`>-alw->`] 
    with Writing[Log, `>-alw->`] 
    with LogWritingUsingSl4j[`>-alw->`]    
    with ComputationTransformer[Active, ActiveLogWriting]
    with ProgramTransformer[`>-a->`, `>-alw->`]
    with WritingTransformer[Log, Active] { 

  // private val logger = LoggerFactory.getLogger(this.getClass)
  
  // override def info[Z, Y](s : String): (Z `>-alw->` Y) => (Z `>-alw->` Y) =
  //   writing(Log { _ => logger.info(s) } )

  // override def infoFunction[Z, Y](s : String): (Z => Y) => (Z `>-alw->` Y) = {`z=>y` =>
  //   writingFunction { z => 
  //     val y = `z=>y`(z) ; 
  //     (Log { _ => logger.info(s"$s($z) == $y") }, y)}
  // }    
  
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

