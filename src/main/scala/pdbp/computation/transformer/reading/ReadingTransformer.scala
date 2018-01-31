package pdbp.computation.transformer.reading

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

import pdbp.types.implicitFunctionType.`>=I=>`

private[pdbp] object readingTransformer {

  type ReadingTransformed = [R, M[+ _]] => [+Z] => (R `>=I=>` M[Z])

}
import readingTransformer._

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.ComputationTransformer

import pdbp.program.reading.Reading

private[pdbp] trait ReadingTransformer[R, M[+ _]: Computation]
    extends ComputationTransformer[M, ReadingTransformed[R, M]] 
    with Computation[ReadingTransformed[R, M]]
    with ProgramTransformer[Kleisli[M], Kleisli[ReadingTransformed[R, M]]]
    with Program[Kleisli[ReadingTransformed[R, M]]]
    with Reading[R, Kleisli[ReadingTransformed[R, M]]] {

  private type RTM = ReadingTransformed[R, M]      

  override private[pdbp] def liftComputation[Z](mz: M[Z]): RTM[Z] =
    mz
    // sys.error(
    //   "Impossible, since, for 'ReadingTransformer', 'liftComputation' is used nowhere")

  import implicitComputation.{bind => bindM}

  // override private[pdbp] def liftObject[Z]: Z => RTM[Z]  = { z =>
  //   resultM(z)
  // }   

  override private[pdbp] def bind[Z, Y](rtmz: RTM[Z], `z>=rtmy`: Z => RTM[Y]): RTM[Y] =
    bindM(rtmz, { z => `z>=rtmy`(z) })

  private type `>=RTK=>` = Kleisli[RTM]   
        
  import implicitComputation.{result => resultM}
  import implicitProgram.{execute => executeKM}

  override def `z>-->r`[Z]: Z `>=RTK=>` R = { _ =>
    resultM(implicitly) 
  }

  override def execute(`u>=rtk=>u`: Unit `>=RTK=>` Unit): Unit = {
    ???   
  }

  def run(`u>=rtk=>u`: Unit `>=RTK=>` Unit): R `>=I=>` Unit = { implicit ir =>
    //type `>=K=>` = Kleisli[M]
    //val `u>=k=>u`: Unit `>=K=>` Unit = u => `u>=rtk=>u`(u)(ir)
    //executeKM(`u>=k=>u`)
    executeKM(u => `u>=rtk=>u`(u)(ir))
  }

}
