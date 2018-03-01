package pdbp.computation.transformation.reading.writing

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

import pdbp.program.reading.Reading

import pdbp.program.writing.Writing

import pdbp.program.writing.folding.Folding

import pdbp.computation.Computation

import  pdbp.computation.transformation.reading.ReadingTransformation

import  pdbp.computation.transformation.reading.readingTransformation._

import pdbp.computation.transformation.writing.writingTransformation._

private[pdbp] trait ReadingWithWritingTransformation[
  R, W : Folding, M[+ _]: Computation : [M[+ _]] => Writing[W, Kleisli[M]]]
    extends ReadingTransformation[R, M]
    with Writing[W, Kleisli[ReadingTransformed[R, M]]] {

  val implicitWriting: Writing[W, Kleisli[M]] = implicitly[Writing[W, Kleisli[M]]]  

  private type RTM = ReadingTransformed[R, M]

  private type `>=RTK=>` = Kleisli[RTM]

  import implicitWriting.{`w>-->u` => `w>-k->u`}
  import implicitWriting.{writingFunction => writingFunctionK}

  override private[pdbp] val `w>-->u`: W `>=RTK=>` Unit = { w =>
    `w>-k->u`(w)
  }

  override private[pdbp] def writingFunction[Z, Y](`z=>(w&&y)`: Z => (W && Y)): Z `>=RTK=>` Y = { z =>
    writingFunctionK(`z=>(w&&y)`: Z => (W && Y))(z)
  }

}      

