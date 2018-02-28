package pdbp.computation.transformer.free.writing.log

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

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.program.Execution

import pdbp.program.writing.log.LogWriting

import pdbp.computation.lifting.LiftingObject

import pdbp.computation.transformer.free.freeTransformer._

import pdbp.computation.transformer.free.writing.FreeWithWritingTransformer

import pdbp.computation.lower.ComputationLower

private[pdbp] trait FreeWithLogWritingTransformer[
  M[+ _]: LiftingObject : [M[+ _]] => Execution[Kleisli[M]] : [M[+ _]] => LogWriting[Kleisli[M]]]
    extends FreeWithWritingTransformer[Log, M]
    with ComputationLower[FreeTransformed[M], M] {

  private type `>=K=>` = Kleisli[M]  

  private type FTM = FreeTransformed[M] 

  private type `>=FTK=>` = Kleisli[FTM]  

  import implicitLiftingObject.{liftObject => liftObjectM}
 
  @annotation.tailrec
  private final def lowerComputationHelper[Z](ftmz: FTM[Z]): M[Z] = ftmz match {
    case LiftObject(z) => 
      liftObjectM(z)
    case LiftComputation(mz) =>
      mz
    case Bind(LiftObject(y), y2ftmz) => 
      lowerComputationHelper(y2ftmz(y))
    case Bind(LiftComputation((Log(effect), y)), y2ftmz) =>
      effect(())
      lowerComputationHelper(y2ftmz(y))
    case Bind(Bind(mx, x2ftmy), y2ftmz) =>
      lowerComputationHelper(bind(mx, compose(x2ftmy, y2ftmz)))          
    case any =>
      sys.error(
        "Impossible, since, for 'ActiveFreeWithLogWritingUsingSl4jProgram', 'lowerComputationHelper' eliminates this case")
  } 

  override private[pdbp] def lowerComputation[Z](ftmz: FTM[Z]): M[Z] = {
    lowerComputationHelper(ftmz)
  }   

}      