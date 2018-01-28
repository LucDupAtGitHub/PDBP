package pdbp.program

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

trait Program[>-->[- _, + _]]
    extends Function[>-->]
    with Composition[>-->]
    with Construction[>-->]
    with Condition[>-->]
    with Aggregation[>-->]
    with Execution[>-->]

private trait ProgramWithApply[>-->[- _, + _]] extends Program[>-->] {

  import pdbp.utils.functionUtils._
  import pdbp.utils.productUtils._

  // Application

  private[pdbp] def apply[Z, Y]: (Z && (Z >--> Y)) >--> Y

  // Binding

//   private[pdbp] def bind[Z, Y](
//       `u>-->z`: Unit >--> Z,
//       `z=>(u>-->y)`: Z => (Unit >--> Y)): Unit >--> Y = {
//     val `z>-->(u>-->y)` : Z >--> (Unit >--> Y) = function(`z=>(u>-->y)`)
//     compose(`u>-->z`, compose(product(`z>-->u`, `z>-->(u>-->y)`), apply))
//   }

  private type M[+Y] = Unit >--> Y

  private[pdbp] def applyUnit[Z, Y]: (Unit && M[Y]) >--> Y =
    apply[Unit, Y]
    
  private[pdbp] def bind[Z, Y](mz: M[Z], `z=>my`: Z => M[Y]): M[Y] = {
    val `u>-->z`: Unit >--> Z = mz  
    val `z>-->my`: Z >--> M[Y] = function(`z=>my`)
    compose(`u>-->z`, compose(product(`z>-->u`, `z>-->my`), applyUnit))
  }

}
