package pdbp.program.instances.function

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

import pdbp.utils.productUtils._
import pdbp.utils.sumUtils._

import pdbp.program.Program

import pdbp.types.function.functionTypes._

object functionProgram extends Program[`>-=->`] {

  override def function[Z, Y](`z>-=->y`: Z `>-=->` Y): Z `>-=->` Y =
    `z>-=->y`

  override def compose[Z, Y, X](`z>-=->y`: Z `>-=->` Y,
                                `y>-=->x`: => Y `>-=->` X): Z `>-=->` X =
    `z>-=->y` andThen `y>-=->x`

  override def product[Z, Y, X](
      `z>-=->y`: Z `>-=->` Y,
      `z>-=->x`: => Z `>-=->` X): Z `>-=->` (Y && X) = { z =>
    (`z>-=->y`(z), `z>-=->x`(z))
  }

  override def sum[Z, Y, X](`y>-=->z`: => Y `>-=->` Z,
                            `x>-=->z`: => X `>-=->` Z): (Y || X) `>-=->` Z =
    foldSum(`y>-=->z`, `x>-=->z`)

  override type Environment = Unit

  override implicit val environment: Environment = ()

  override def execute(`u>-=->u`: Unit `>-=->` Unit): Environment `I=>` Unit =
    `u>-=->u`(())

}
