package pdbp.computation.transformer.writing.log.sl4j

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

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.types.log.logTypes._

import pdbp.program.Execution

import pdbp.computation.Computation

import pdbp.computation.transformer.writing.log.logWritingTransformer._

import pdbp.computation.transformer.writing.log.LogWritingTransformer

private[pdbp] trait LogWritingUsingSl4jTransformer[M[+ _]: Computation]
    extends LogWritingTransformer[M]
    with Execution[Kleisli[LogWritingTransformed[M]]] {

  import implicitComputation.{result => resultM}
  import implicitComputation.{bind => bindM}

  import implicitProgram.{execute => executeK}

  private type LWTM = LogWritingTransformed[M]

  private type `>=LWTK=>` = Kleisli[LWTM]

  override def execute(`u>=lwtk=>u`: Unit `>=LWTK=>` Unit): Environment `I=>` Unit = {
    executeK { u: Unit =>
      bindM(`u>=lwtk=>u`(u), { (log, u) =>
        log.effect(())
        resultM(u)
      })
    } 
  }

}