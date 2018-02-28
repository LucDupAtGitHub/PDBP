package pdbp.program.instances.active.reading.writing.log

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

import pdbp.types.log.logTypes._

import pdbp.types.active.writing.log.activeLogWritingTypes._

import pdbp.computation.transformer.reading.writing.log.ReadingWithLogWritingTransformer

import pdbp.program.instances.active.reading.writing.ActiveReadingWithWritingProgram

trait ActiveReadingWithLogWritingProgram[R]
    extends ActiveReadingWithWritingProgram[R, Log]
    with ReadingWithLogWritingTransformer[R, ActiveLogWriting]