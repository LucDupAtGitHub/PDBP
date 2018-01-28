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

object productUtils {
  type &&[+Z, +Y] = (Z, Y)

  def `(y&&x)=>(y&&x)`[Y, X]: (Y && X) => (Y && X) = { `y&&x` =>
    `y&&x`
  }  

  def `(z&&y)=>z`[Z, Y]: (Z && Y) => Z = { (z, _) =>
    z
  }

  def `(z&&y)=>y`[Z, Y]: (Z && Y) => Y = { (_, y) =>
    y
  } 

  def `((z&&y)&&x)=>(y&&x)`[Z, Y, X]: ((Z && Y) && X) => (Y && X) = {
    case ((_, y), x) => (y, x)
  }   

  def `(z&&(y&&x))=>z`[Z, Y, X]: (Z && (Y && X)) => Z = {
    case (z, (_, _)) => z
  }    

  def `(z&&(y&&x))=>y`[Z, Y, X]: (Z && (Y && X)) => Y = {
    case (_, (y, _)) => y
  }  

  def `(z&&(y&&x))=>x`[Z, Y, X]: (Z && (Y && X)) => X = {
    case (_, (_, x)) => x
  } 

  def `((z=>y)&&z)=>y`[Z, Y]: ((Z => Y) && Z) => Y = { (`z=>y`, z) => `z=>y`(z)
  }  

  def `(z&&y)=>(z&&y)`[Z, Y]: (Z && Y) => (Z && Y) = { `z&&y` =>
    `z&&y`
  }

  def `(z=>x)=>(z&&y)=>(x&&y)`[Z, Y, X]: (Z => X) => (Z && Y) => (X && Y) = {
    `z=>x` => (z, y) =>
      (`z=>x`(z), y)
  }    
  
}
