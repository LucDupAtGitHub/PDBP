package pdbp.computation.transformer.free.writing

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

import pdbp.computation.lifting.LiftingObject

import  pdbp.computation.transformer.free.FreeTransformer

import  pdbp.computation.transformer.free.freeTransformer._

import pdbp.computation.transformer.writing.writingTransformer._

private[pdbp] trait FreeWithWritingTransformer[
  W : Folding, M[+ _]: LiftingObject : [M[+ _]] => Execution[Kleisli[M]] : [M[+ _]] => Writing[W, Kleisli[M]]]
    extends FreeTransformer[M]
    with Writing[W, Kleisli[FreeTransformed[M]]] {

  val implicitWriting: Writing[W, Kleisli[M]] = implicitly[Writing[W, Kleisli[M]]]  

  private type FTM = FreeTransformed[M]

  private type `>=FTK=>` = Kleisli[FTM]

  import implicitWriting.{`w>-->u` => `w>-k->u`}
  import implicitWriting.{writingFunction => writingFunctionK}

  override private[pdbp] val `w>-->u`: W `>=FTK=>` Unit = 
    liftProgram(`w>-k->u`)

  override private[pdbp] def writingFunction[Z, Y](`z=>(w&&y)`: Z => (W && Y)): Z `>=FTK=>` Y =
    liftProgram(writingFunctionK(`z=>(w&&y)`))
    
}      

