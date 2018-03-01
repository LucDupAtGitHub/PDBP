package pdbp.computation

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

import pdbp.types.kleisli.kleisliFunctionType.Kleisli

import pdbp.program.Program

import pdbp.computation.lifting.Lifting
import pdbp.computation.lifting.Sequencing

import pdbp.computation.binding.Binding

private[pdbp] trait Computation[M[+ _]]
    extends Binding[M]
    with Lifting[M]
    with Sequencing[M]
    with Program[Kleisli[M]] {

  private[pdbp] def result[Z]: Z => M[Z] =
    liftObject

  import pdbp.utils.productUtils._
  import pdbp.utils.sumUtils._

  // Lifting

  override private[pdbp] def liftObject[Z](z: Z): M[Z] =
    result(z)

  override private[pdbp] def liftFunction[Z, Y](
      `z=>y`: Z => Y): M[Z] => M[Y] = { mz =>
    bind(mz, z => result(`z=>y`(z)))
  }

  override private[pdbp] def liftOperator[Z, Y, X](
      `(z&&y)=>x`: (Z && Y) => X): (M[Z] && M[Y]) => M[X] = { (mz, my) =>
    bind(mz, z => bind(my, y => result(`(z&&y)=>x`(z, y))))
  }

  // Program

  private type `>=K=>` = Kleisli[M]

  override def function[Z, Y](`z=>y`: Z => Y): Z `>=K=>` Y = { z =>
    result(`z=>y`(z))
  }

  override def compose[Z, Y, X](`z>=k=>y`: Z `>=K=>` Y,
                                `y>=k=>x`: => Y `>=K=>` X): Z `>=K=>` X = { z =>
    bind(`z>=k=>y`(z), `y>=k=>x`)
  }

  override def product[Z, Y, X](
      `z>=k=>y`: Z `>=K=>` Y,
      `z>=k=>x`: => Z `>=K=>` X): Z `>=K=>` (Y && X) = { z =>
    bind(`z>=k=>y`(z), y => bind(`z>=k=>x`(z), x => result(y, x)))
  }

  override def sum[Z, Y, X](`y>=k=>z`: => Y `>=K=>` Z,
                            `x>=k=>z`: => X `>=K=>` Z): (Y || X) `>=K=>` Z =
    foldSum(`y>=k=>z`, `x>=k=>z`)

}

private trait ComputationWithApply[M[+ _]] extends Computation[M] {

  import pdbp.utils.productUtils._

  private type `>=K=>` = Kleisli[M]

  // Application

  private[pdbp] def apply[Z, Y]: (Z && (Z `>=K=>` Y)) `>=K=>` Y = {
    (z, `z>=k=>y`) =>
      bind(result(z), `z>=k=>y`)
  }

}
