package pdbp.program.instances.active.free

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.types.active.activeTypes._

import pdbp.types.active.free.activeFreeTypes._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.NaturalTransformation

import pdbp.computation.transformation.ComputationTransformation

import pdbp.computation.transformation.free.FreeTransformation

import pdbp.program.implicits.active.implicits.implicitActiveProgram

object activeFreeProgram
    extends Computation[ActiveFree]
    with Program[`>-af->`]
    with NaturalTransformation[Active, ActiveFree]()
    with ComputationTransformation[Active, ActiveFree]()
    with ProgramTransformation[`>-a->`, `>-af->`]()
    with FreeTransformation[Active]()
