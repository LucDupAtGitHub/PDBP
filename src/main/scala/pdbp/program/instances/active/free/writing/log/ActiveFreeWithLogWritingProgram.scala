package pdbp.program.instances.active.free.writing.log

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

import pdbp.types.active.writing.log.activeLogWritingTypes._

import pdbp.computation.transformation.free.writing.log.FreeWithLogWritingTransformation

import pdbp.program.instances.active.free.writing.ActiveFreeWithWritingProgram

trait ActiveFreeWithLogWritingProgram
    extends ActiveFreeWithWritingProgram[Log]
    with FreeWithLogWritingTransformation[ActiveLogWriting]