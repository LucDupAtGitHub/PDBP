package pdbp.computation.transformation.free.writing.log

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

import pdbp.computation.lifting.ObjectLifting

import pdbp.computation.transformation.free.freeTransformation._

import pdbp.computation.transformation.free.writing.FreeWithWritingTransformation

import pdbp.computation.recuperation.NaturalRecuperation

private[pdbp] trait FreeWithLogWritingTransformation[
  M[+ _]: ObjectLifting : [M[+ _]] => Execution[Kleisli[M]] : [M[+ _]] => LogWriting[Kleisli[M]]]
    extends FreeWithWritingTransformation[Log, M]
    with NaturalRecuperation[FreeTransformed[M], M] {

  private type `>=K=>` = Kleisli[M]  

  private type FTM = FreeTransformed[M] 

  private type `>=FTK=>` = Kleisli[FTM]  

  import implicitObjectLifting.{liftObject => liftObjectM}
 
  @annotation.tailrec
  private final def recuperateHelper[Z](ftmz: FTM[Z]): M[Z] = ftmz match {
    case LiftObject(z) => 
      liftObjectM(z)
    case TransformComputation(mz) =>
      mz
    case Bind(LiftObject(y), y2ftmz) => 
      recuperateHelper(y2ftmz(y))
    case Bind(TransformComputation((Log(effect), y)), y2ftmz) =>
      effect(())
      recuperateHelper(y2ftmz(y))
    case Bind(Bind(mx, x2ftmy), y2ftmz) =>
      recuperateHelper(bind(mx, compose(x2ftmy, y2ftmz)))          
    case any =>
      sys.error(
        "Impossible, since, for 'FreeWithLogWritingTransformation', 'recuperateHelper' eliminates this case")
  } 

  override private[pdbp] def recuperate[Z](ftmz: FTM[Z]): M[Z] = {
    recuperateHelper(ftmz)
  }   

}      