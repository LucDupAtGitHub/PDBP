package pdbp.program.writing.log

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.types.log.logTypes._

import pdbp.program.Function

import pdbp.program.Composition

import pdbp.program.Construction

import pdbp.program.writing.Writing

trait LogWriting[>-->[- _, + _]] extends Writing[Log, >-->] {
  this: Function[>-->] & Composition[>-->] & Construction[>-->] => 

  def info[Z, Y](s: String): (Z >--> Y) => (Z >--> Y)

  def infoFunction[Z, Y](s: String): (Z => Y) => (Z >--> Y)

}


