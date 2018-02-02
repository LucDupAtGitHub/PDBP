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

import pdbp.program.writing.log.Logging

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.computation.transformer.writing.WritingTransformer

import pdbp.types.active.activeTypes._

import pdbp.program.implicits.active.implicits.implicitActiveProgram

import pdbp.types.active.writing.log.activeLoggingTypes._

import pdbp.program.instances.active.writing.ActiveWritingProgram

import pdbp.program.writing.canbewritten.implicits.log.implicits.implicitLogCanBeWritten

object activeLoggingUsingSl4jProgram
    extends ActiveWritingProgram[Log]
    with WritingTransformer[Log, Active]()
    with ComputationTransformer[Active, ActiveLogging]()
    with Computation[ActiveLogging]
    with ProgramTransformer[`>-a->`, `>-al->`]()
    with Program[`>-al->`] 
    with Writing[Log, `>-al->`]() 
    with Logging[`>-al->`] {

  val logger = LoggerFactory.getLogger(this.getClass)

  import logger._
  
  override def info[Z, Y](s : String): (Z `>-al->` Y) => (Z `>-al->` Y) =
    write(Log { _ => info(s) } )

  override def functionWithInfo[Z, Y](s : String): (Z => Y) => (Z `>-al->` Y) = {`z=>y` =>
    write({ z => (Log { _ => logger.info(s"$s($z)") }, `z=>y`(z) )})
  }    
  
  import implicitComputation.{result => resultM}
  import implicitComputation.{bind => bindM}

  import implicitProgram.{environment => environmentK}
  import implicitProgram.{execute => executeK}

  override implicit val environment: Environment = {
    environmentK
  }

  override def execute(`u>-al->u`: Unit `>-al->` Unit): Environment `I=>` Unit = {
    executeK { u: Unit =>
      bindM(`u>-al->u`(u), { (log, u) =>
        log.effect(())
        resultM(u)
      })
    } 
  }


}
