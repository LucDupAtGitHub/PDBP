package pdbp.program.implicits.active.reading.int.console

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

  import pdbp.program.instances.active.reading.int.console.activeIntReadingFromConsoleProgram

  implicit val implicitActiveIntReadingFromConsoleProgram: activeIntReadingFromConsoleProgram.type =
    activeIntReadingFromConsoleProgram

}
