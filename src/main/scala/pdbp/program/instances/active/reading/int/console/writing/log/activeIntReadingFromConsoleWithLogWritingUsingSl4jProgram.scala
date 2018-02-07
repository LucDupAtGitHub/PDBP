package pdbp.program.instances.active.reading.int.console.writing.log.sl4j

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

import pdbp.utils.runUtils._

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.types.log.logTypes._

import pdbp.program.Program

import pdbp.program.reading.Reading

import pdbp.program.reading.int.console.IntReadingFromConsole

import pdbp.program.writing.Writing

import pdbp.program.writing.log.LogWriting

import pdbp.program.writing.log.sl4j.LogWritingUsingSl4j

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.computation.transformer.reading.ReadingTransformer

import pdbp.program.writing.folding.implicits.log.implicits.implicitLogFolding

import pdbp.computation.transformer.writing.writingTransformer._

import pdbp.computation.transformer.reading.writing.ReadingWithWritingTransformer

import pdbp.program.instances.active.reading.writing.ActiveReadingWithWritingProgram

import pdbp.program.instances.active.writing.log.sl4j.activeLogWritingUsingSl4jProgram

import pdbp.types.active.reading.int.writing.log.activeIntReadingWithLogWritingTypes._

import pdbp.types.active.activeTypes._

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.types.active.writing.log.activeLogWritingTypes._

import pdbp.program.instances.active.reading.int.console.activeIntReadingFromConsoleProgram

import pdbp.program.implicits.active.writing.log.sl4j.implicits.implicitActiveLogWritingUsingSl4jProgram

trait ActiveIntReadingFromConsoleWithLogWritingUsingSl4jProgram
    extends Computation[ActiveIntReadingWithLogWriting]
    with Program[`>-airlw->`]
    with LogWritingUsingSl4j[`>-airlw->`]    
    with IntReadingFromConsole[`>-airlw->`]   
    with ReadingWithWritingTransformer[BigInt, Log, ActiveLogWriting]

object activeIntReadingFromConsoleWithLogWritingUsingSl4jProgram
    extends ActiveIntReadingFromConsoleWithLogWritingUsingSl4jProgram 
    with Writing[Log, `>-airlw->`]() 
    with ComputationTransformer[ActiveLogWriting, ActiveIntReadingWithLogWriting]()
    with ProgramTransformer[`>-alw->`, `>-airlw->`]() 
    with ReadingTransformer[BigInt, ActiveLogWriting]() 
    with ReadingWithWritingTransformer[BigInt, Log, ActiveLogWriting]() {

  // import org.slf4j.LoggerFactory

  // private val logger = LoggerFactory.getLogger(this.getClass)
  
  // override def info[Z, Y](s : String): (Z `>-airlw->` Y) => (Z `>-airlw->` Y) =
  //   writing(Log { _ => logger.info(s) } )

  // override def infoFunction[Z, Y](s : String): (Z => Y) => (Z `>-airlw->` Y) = {`z=>y` =>
  //   writingFunction { z => 
  //     val y = `z=>y`(z) ; 
  //     (Log { _ => logger.info(s"$s($z) == $y") }, y)}
  // } 

  // TODO: check types
  //implicit val implicitIntReadFromConsole: BigInt = 
    // intReadFromConsole(())

  import implicitProgram.{environment => environmentK}

  override implicit val environment: Environment = {
    (environmentK, activeIntReadingFromConsoleProgram.implicitIntReadFromConsole)
  }

}