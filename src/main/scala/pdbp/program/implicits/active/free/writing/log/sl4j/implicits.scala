package pdbp.program.implicits.active.free.writing.log.sl4j

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

object implicits {

  import pdbp.program.instances.active.free.writing.log.sl4j.activeFreeWithLogWritingUsingSl4jProgram

  implicit val implicitActiveFreeWithLogWritingUsingSl4jProgram: activeFreeWithLogWritingUsingSl4jProgram.type =
    activeFreeWithLogWritingUsingSl4jProgram

}
