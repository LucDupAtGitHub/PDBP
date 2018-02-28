package pdbp.program.instances.active.writing.free

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.types.active.free.activeFreeTypes._

import pdbp.types.active.writing.free.activeWritingWithFreeTypes._

import pdbp.utils.productUtils._

import pdbp.program.Program

import pdbp.program.writing.folding.Folding

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.computation.transformer.writing.writingTransformer._

import pdbp.computation.transformer.writing.WritingTransformer

import pdbp.program.instances.active.free.activeFreeProgram

trait ActiveWritingWithFreeProgram[W : Folding]
    extends Computation[ActiveWritingWithFree[W]]
    with Program[`>-awf->`[W]]
    with ComputationTransformer[ActiveFree, ActiveWritingWithFree[W]]
    with ProgramTransformer[`>-af->`, `>-awf->`[W]]
    with WritingTransformer[W, ActiveFree] {

  private type AWFW = ActiveWritingWithFree[W] // WritingTransformed[W, ActiveFree]
  private type `>-awfw->` = `>-awf->`[W]

  import implicitFolding._

  import implicitComputation.{bind => bindM}
  import implicitComputation.{result => resultM}

  override private[pdbp] def bind[Z, Y](wtafz: AWFW[Z],
                                        `z=>wtafy`: Z `>-awfw->` Y): AWFW[Y] =
    bindM(wtafz, { (w1, z) =>
      val (w2, y): W && Y = activeFreeProgram.lowerComputation(`z=>wtafy`(z))
      resultM(append(w1, w2), y)
    })

}

