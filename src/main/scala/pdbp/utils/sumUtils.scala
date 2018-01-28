package pdbp.utils

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

object sumUtils {

  case class Left[+Z](z: Z)
  
  case class Right[+Y](y: Y)

  type ||[+Z, +Y] = Left[Z] | Right[Y]

  def `(y||x)=>(y||x)`[Y, X]: (Y || X) => (Y || X) = { `y||x` =>
    `y||x`
  }  

  def `z=>(z||y)`[Z, Y]: Z => (Z || Y) = { z =>
    Left(z)
  }

  def `y=>(z||y)`[Z, Y]: Y => (Z || Y) = { y =>
    Right(y)
  }

  def foldSum[Z, Y, X](`y=>z`: => Y => Z, `x=>z`: => X => Z): (Y || X) => Z = {
    case Left(y) =>
      `y=>z`(y)
    case Right(x) =>
      `x=>z`(x)
  }

  def `(y||x)=>b`[Y, X]: (Y || X) => Boolean =
    foldSum[Boolean, Y, X](_ => true, _ => false)

  def `(y||x)=>y`[Y, X]: (Y || X) => Y =
    foldSum[Y, Y, X](y => y, _ => ???)

  def `(y||x)=>x`[Y, X]: (Y || X) => X =
    foldSum[X, Y, X](_ => ???, x => x)

}
