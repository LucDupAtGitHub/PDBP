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

import pdbp.utils.functionUtils._
import pdbp.utils.productUtils._

trait Function[>-->[- _, + _]] {

  def function[Z, Y](`z=>y`: Z => Y): Z >--> Y

  def `z>-->z`[Z]: Z >--> Z =
    function(`z=>z`)  

  def `(y&&x)>-->(y&&x)`[Y, X]: (Y && X) >--> (Y && X) =
    function(`(y&&x)=>(y&&x)`)

  def `(z&&y)>-->z`[Z, Y]: (Z && Y) >--> Z =
    function(`(z&&y)=>z`)

  def `(z&&y)>-->y`[Z, Y]: (Z && Y) >--> Y =
    function(`(z&&y)=>y`)

  def `((z&&y)&&x)>-->(y&&x)`[Z, Y, X]: ((Z && Y) && X) >--> (Y && X) =
    function(`((z&&y)&&x)=>(y&&x)`)    

}
