package pdbp.program.transformer

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

import pdbp.program.Program

trait ProgramTransformer[`>-D->`[- _, + _]: Program, `>-U->`[- _, + _]] {

  private[pdbp] val implicitProgram = implicitly[Program[`>-D->`]]

  private[pdbp] def liftProgram[Z, Y](`z>-d->y`: Z `>-D->` Y): Z `>-U->` Y

}
