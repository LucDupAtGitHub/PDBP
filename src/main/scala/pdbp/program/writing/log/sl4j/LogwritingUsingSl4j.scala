package pdbp.program.writing.log.sl4j

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import org.slf4j.LoggerFactory

import pdbp.types.log.logTypes._

import pdbp.program.Function

import pdbp.program.Composition

import pdbp.program.Construction

import pdbp.program.writing.Writing

import pdbp.program.writing.log.LogWriting

trait LogWritingUsingSl4j[>-->[- _, + _]] extends LogWriting[>-->] {
  this: Function[>-->] & Composition[>-->] & Construction[>-->] =>

  private val logger = LoggerFactory.getLogger(this.getClass)  

  override def withInfo[Z, Y](s : String): (Z >--> Y) => (Z >--> Y) =
    writing(Log { _ => logger.info(s) } )

  override def functionWithInfo[Z, Y](s : String): (Z => Y) => (Z >--> Y) = {`z=>y` =>
    writingFunction { z => 
      val y = `z=>y`(z) ; 
      (Log { _ => logger.info(s"$s($z) == $y") }, y)
    }
  } 

}