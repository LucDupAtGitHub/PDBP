package pdbp.lifting

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

import pdbp.utils.productUtils._

private[pdbp] trait Lifting[M[+ _]]
    extends LiftObject[M]
    with LiftFunction[M]
    with LiftOperator[M] {

  private[pdbp] def liftedAnd[Z, Y]: (M[Z] && M[Y]) => M[Z && Y] =
    liftOperator(`(z&&y)=>(z&&y)`)

  private[pdbp] def liftedApply[Z, Y]: (M[Z => Y] && M[Z]) => M[Y] =
    liftOperator(`((z=>y)&&z)=>y`)

  private[pdbp] override def liftFunction[Z, Y](`z=>y`: Z => Y): M[Z] => M[Y] =
    liftedApply(liftObject(`z=>y`), _)

  private[pdbp] def lift3[Z, Y, X, W](`((z&&y)&&x)=>w`: ((Z && Y) && X) => W)
    : ((M[Z] && M[Y]) && M[X]) => M[W] =
    `(z=>x)=>(z&&y)=>(x&&y)`(liftedAnd) andThen liftOperator(`((z&&y)&&x)=>w`)

  // ,,,
    
}
