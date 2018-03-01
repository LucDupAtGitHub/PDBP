package pdbp.computation.transformation.free.writing

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

import pdbp.program.Execution

import pdbp.program.writing.Writing

import pdbp.program.writing.folding.Folding

import pdbp.computation.Computation

import pdbp.computation.lifting.ObjectLifting

import  pdbp.computation.transformation.free.FreeTransformation

import  pdbp.computation.transformation.free.freeTransformation._

import pdbp.computation.transformation.writing.writingTransformation._

private[pdbp] trait FreeWithWritingTransformation[
  W : Folding, M[+ _]: ObjectLifting : [M[+ _]] => Execution[Kleisli[M]] : [M[+ _]] => Writing[W, Kleisli[M]]]
    extends FreeTransformation[M]
    with Writing[W, Kleisli[FreeTransformed[M]]] {

  val implicitWriting: Writing[W, Kleisli[M]] = implicitly[Writing[W, Kleisli[M]]]  

  private type FTM = FreeTransformed[M]

  private type `>=FTK=>` = Kleisli[FTM]

  import implicitWriting.{`w>-->u` => `w>-k->u`}
  import implicitWriting.{writingFunction => writingFunctionK}

  override private[pdbp] val `w>-->u`: W `>=FTK=>` Unit = 
    transformProgram(`w>-k->u`)

  override private[pdbp] def writingFunction[Z, Y](`z=>(w&&y)`: Z => (W && Y)): Z `>=FTK=>` Y =
    transformProgram(writingFunctionK(`z=>(w&&y)`))
    
}      

