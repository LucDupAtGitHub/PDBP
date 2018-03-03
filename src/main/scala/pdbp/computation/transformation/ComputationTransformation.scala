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

private[pdbp] trait ComputationTransformation[F[+ _]: [F[+ _]] => Execution[Kleisli[F]], T[+ _]]
    extends ProgramTransformation[Kleisli[F], Kleisli[T]] {

  // TODO: would be better in FreeTransformation
  private[pdbp] val implicitExecution = implicitly[Execution[Kleisli[F]]]

  private[pdbp] def transformComputation: F ~> T

  private type `=>F` = Kleisli[F]

  private type `=>T` = Kleisli[T]  

  import pdbp.program.transformation.{ ~> =>  ~~> }
 
  override private[pdbp] def transformProgram: `=>F` ~~> `=>T` = 
    new ~~> {
      override def apply[Z, Y](`z=>fy`: Z `=>F` Y): Z `=>T` Y = { z =>
        transformComputation.apply[Y](`z=>fy`(z))
      } 
    }    

}

