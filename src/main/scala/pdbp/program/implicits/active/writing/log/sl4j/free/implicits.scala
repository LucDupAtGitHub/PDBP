package pdbp.program.implicits.active.writing.log.sl4j.free

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

  import pdbp.program.instances.active.writing.log.sl4j.free.activeLogWritingUsingSl4jFreeProgram

  implicit val implicitActiveLogWritingUsingSl4jFreeProgram: activeLogWritingUsingSl4jFreeProgram.type =
    activeLogWritingUsingSl4jFreeProgram

}
