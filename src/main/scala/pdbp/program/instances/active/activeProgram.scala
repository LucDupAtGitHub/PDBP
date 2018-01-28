package pdbp.program.instances.active

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

import pdbp.utils.functionUtils._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.types.active.activeTypes._

object activeProgram extends Computation[Active] with Program[`>-a->`] {

  override private[pdbp] def liftObject[Z]: Z => Active[Z] = `z=>az`

  override private[pdbp] def bind[Z, Y](az: Active[Z],
                                        `z=>ay`: Z => Active[Y]): Active[Y] =
    `z=>ay`(az)

  override def execute(`u>-a->u`: Unit `>-a->` Unit): Unit =
    `u>-a->u`(())
}