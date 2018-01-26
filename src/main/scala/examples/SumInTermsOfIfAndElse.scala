package examples

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

import pdbp.utils.sumUtils._

import pdbp.program.Function
import pdbp.program.Composition
import pdbp.program.Condition

import pdbp.program.compositionOperator._

trait SumInTermsOfIfAndElse[>-->[- _, + _]: Function: Composition: Condition] {
  val implicitFunction  = implicitly[Function[>-->]]
  val implicitCondition = implicitly[Condition[>-->]]

  import implicitFunction._
  import implicitCondition._

  def sum[Z, Y, X](`y>-->z`: => Y >--> Z,
                   `x>-->z`: => X >--> Z): (Y || X) >--> Z =
    `if`(`(y||x)>-->b`) {
      `(y||x)>-->y` >--> `y>-->z`
    } `else` {
      `(y||x)>-->x` >--> `x>-->z`
    }

}
