package pdbp.program.writing

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.utils.productUtils._

import pdbp.program.Function

import pdbp.program.Composition

import pdbp.program.Construction

import pdbp.program.writing.folding.Folding

trait Writing[W: Folding, >-->[- _, + _]] {
  this: Function[>-->] & Composition[>-->] & Construction[>-->] =>

  private[pdbp] val `w>-->u`: W >--> Unit

  private[pdbp] def writing[Z, Y](w: W): (Z >--> Y) => (Z >--> Y) = { `z>-->y` =>
    compose(product(compose(`w=>(z>-->w)`(w), `w>-->u`), `z>-->y`), `(u&&y)>-->y`)
  }  

  private[pdbp] def writingFunction[Z, Y](`z=>(w&&y)`: Z => (W && Y)): Z >--> Y

}
