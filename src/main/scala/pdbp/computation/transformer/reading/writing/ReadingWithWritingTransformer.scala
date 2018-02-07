package pdbp.computation.transformer.reading.writing

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

import pdbp.utils.productUtils._

import pdbp.program.writing.folding.Folding

import pdbp.program.Execution

import pdbp.program.reading.Reading

import pdbp.program.writing.Writing

import pdbp.computation.Computation

import  pdbp.computation.transformer.reading.readingTransformer._
import  pdbp.computation.transformer.reading.ReadingTransformer

import pdbp.computation.transformer.writing.writingTransformer._

private[pdbp] trait ReadingWithWritingTransformer[R, W : Folding, M[+ _]: Computation : [M[+ _]] => Writing[W, Kleisli[M]]]
    extends ReadingTransformer[R, M]
    with Writing[W, Kleisli[ReadingTransformed[R, M]]] {

  val implicitWriting: Writing[W,  Kleisli[M]] = implicitly[Writing[W, Kleisli[M]]]  

  private type RTM = ReadingTransformed[R, M]

  private type `>=RTK=>` = Kleisli[RTM]

  override private[pdbp] val `w>-->u`: W `>=RTK=>` Unit = { w =>
    implicitWriting.`w>-->u`(w)
  }

  override private[pdbp] def writingFunction[Z, Y](`z=>(w&&y)`: Z => (W && Y)): Z `>=RTK=>` Y = { z =>
    implicitWriting.writingFunction(`z=>(w&&y)`: Z => (W && Y))(z)
  }

}      

