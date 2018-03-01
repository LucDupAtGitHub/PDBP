package pdbp.computation.transformation

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

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.program.Execution

import pdbp.computation.Computation

import pdbp.computation.lifting.ObjectLifting

import pdbp.program.transformation.ProgramTransformation

private[pdbp] trait ComputationTransformation[M[+ _]: ObjectLifting: [M[+ _]] => Execution[Kleisli[M]], N[+ _]]
    extends NaturalTransformation[M, N]
    with ProgramTransformation[Kleisli[M], Kleisli[N]] 
    with ObjectLifting[N] {

  private[pdbp] val implicitObjectLifting = implicitly[ObjectLifting[M]]

  override private[pdbp] def liftObject[Z](z: Z) =
    apply(implicitObjectLifting.liftObject(z))

  private[pdbp] val implicitExecution = implicitly[Execution[Kleisli[M]]]

}