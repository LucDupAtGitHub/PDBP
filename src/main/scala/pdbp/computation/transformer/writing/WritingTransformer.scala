package pdbp.computation.transformer.writing

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

import pdbp.utils.productUtils._

private[pdbp] object writingTransformer {

  type WritingTransformed = [W, M[+ _]] => [+Z] => M[W && Z]

}

import writingTransformer._

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.types.implicitFunctionType.`I=>`

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.program.writing.canbewritten.CanBeWritten

import pdbp.program.writing.Writing

trait WritingTransformer[W: CanBeWritten, M[+ _]: Computation]
    extends Computation[WritingTransformed[W, M]]
    with Program[Kleisli[WritingTransformed[W, M]]]
    with Writing[W, Kleisli[WritingTransformed[W, M]]]
    with ComputationTransformer[M, WritingTransformed[W, M]]
    with ProgramTransformer[Kleisli[M], Kleisli[WritingTransformed[W, M]]] {

  private type WTM = WritingTransformed[W, M]

  val implicitCanBeWritten = implicitly[CanBeWritten[W]]

  import implicitCanBeWritten._

  import implicitComputation.{bind => bindM}
  import implicitComputation.{result => resultM}

  override private[pdbp] def liftComputation[Z](mz: M[Z]): WTM[Z] = {
    bindM(mz, { z =>
      resultM((empty, z))
    })
  }

  override private[pdbp] def bind[Z, Y](wtmz: WTM[Z],
                                        `z=>wtmy`: Z => WTM[Y]): WTM[Y] =
    bindM(wtmz, { (w1, z) =>
      val (w2, y): W && Y = `z=>wtmy`(z)
      resultM(append(w1, w2), y)
    })

  private type `>=WTK=>` = Kleisli[WTM]

  import implicitProgram.{Environment => EnvironmentK}
  import implicitProgram.{execute => executeK}

  override type Environment = EnvironmentK

  override def execute(
      `u>=wtk=>u`: Unit `>=WTK=>` Unit): Environment `I=>` Unit = {
    implicit environment =>
      executeK { u: Unit =>
        bindM(`u>=wtk=>u`(u), {
          case (_, u) =>
            resultM(u)
        })
      }
  }

  override private[pdbp] val `w>-->u`: W `>=WTK=>` Unit = { w =>
    resultM((w, ()))
  }

  override def write[Z, Y](`z=>(w&&y)`: Z => (W && Y)): Z `>=WTK=>` Y = { z =>
    resultM(`z=>(w&&y)`(z))
  }

}
