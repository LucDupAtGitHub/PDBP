package pdbp.program.instances.writing.log.sl4j

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

import pdbp.types.log.logTypes._

import org.slf4j.LoggerFactory

import pdbp.program.Program

import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.computation.transformer.writing.WritingTransformer

import pdbp.types.active.activeTypes._

import pdbp.program.implicits.active.implicits.implicitActiveProgram

import pdbp.types.active.writing.log.activeLogWritingTypes._

import pdbp.program.instances.active.writing.ActiveWritingProgram

import pdbp.program.writing.canbewritten.implicits.log.implicits.implicitLogCanBeWritten

object activeLogWritingUsingSl4jProgram
    extends ActiveWritingProgram[Log]
    with WritingTransformer[Log, Active]()
    with ComputationTransformer[Active, ActiveLogWriting]()
    with Computation[ActiveLogWriting]
    with ProgramTransformer[`>-a->`, `>-alw->`]()
    with Program[`>-alw->`] 
    with Writing[Log, `>-alw->`]() {

  def logger = LoggerFactory.getLogger(this.getClass)
  
  def info[Z, Y]: String => (Z `>-alw->` Y) => (Z `>-alw->` Y) = { s =>
    writing(Log(effect = { _ => logger.info(s) }))
  }
  
  import implicitProgram.{environment => environmentK}

  override implicit val environment: Environment = {
    environmentK
  }

}
