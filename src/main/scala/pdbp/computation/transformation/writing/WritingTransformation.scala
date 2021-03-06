package pdbp.computation.transformation.writing

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

private[pdbp] object writingTransformation {

  type WritingTransformed = [W, M[+ _]] => [+Z] => M[W && Z]

}

import writingTransformation._

import pdbp.types.implicitFunctionType.`I=>`

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.program.Program

import pdbp.program.writing.folding.Folding

import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.~>

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait WritingTransformation[W: Folding, M[+ _]: Computation]
    extends Computation[WritingTransformed[W, M]]
    with Program[Kleisli[WritingTransformed[W, M]]]
    with Writing[W, Kleisli[WritingTransformed[W, M]]]
    with ComputationTransformation[M, WritingTransformed[W, M]]
    with ProgramTransformation[Kleisli[M], Kleisli[WritingTransformed[W, M]]] {

  private type WTM = WritingTransformed[W, M]

  val implicitFolding = implicitly[Folding[W]]

  import implicitFolding._

  private[pdbp] val implicitComputation = implicitly[Computation[M]]  

  import implicitComputation.{bind => bindM}
  import implicitComputation.{result => resultM}

  override private[pdbp] def result[Z]: Z => WTM[Z] = { z =>
    resultM((start, z))
  }

  override private[pdbp] def transformComputation = new (M ~> WTM) {
    override private[pdbp] def apply[Z](mz: M[Z]): WTM[Z] = 
      bindM(mz, { z =>
        resultM((start, z))
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
  import implicitProgram.{environment => environmentK}
  import implicitProgram.{execute => executeK}

  override type Environment = EnvironmentK

  override implicit val environment: Environment = {
    environmentK
  }

  override private[pdbp] val `w>-->u`: W `>=WTK=>` Unit = { w =>
    resultM((w, ()))
  }

  override private[pdbp] def writingFunction[Z, Y](`z=>(w&&y)`: Z => (W && Y)): Z `>=WTK=>` Y = { z =>
    resultM(`z=>(w&&y)`(z))
  }

}
