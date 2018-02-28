package pdbp.computation.transformer.reading.int.console

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

import pdbp.utils.runUtils._

import pdbp.program.Function

import pdbp.program.Composition

import pdbp.program.Execution

import pdbp.computation.Computation

import pdbp.computation.transformer.reading.int.intReadingTransformer._

import pdbp.computation.transformer.reading.int.IntReadingTransformer

private[pdbp] trait ImplicitIntReadingFromConsoleTransformer[M[+ _]: Computation]
    extends IntReadingTransformer[M]
    with Execution[Kleisli[IntReadingTransformed[M]]] {

  private implicit val implicitIntReadFromConsole: BigInt = 
    readIntFunction("please type an integer to read")(())       

  import implicitProgram.{ environment => environmentK }

  override implicit val environment: Environment = {
    (environmentK, implicitIntReadFromConsole)
  }

}