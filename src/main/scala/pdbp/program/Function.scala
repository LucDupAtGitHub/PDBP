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
import pdbp.utils.sumUtils._
import pdbp.utils.productAndSumUtils._
import pdbp.utils.runUtils._

trait Function[>-->[- _, + _]] {

  def function[Z, Y](`z=>y`: Z => Y): Z >--> Y

  def `z>-->z`[Z]: Z >--> Z =
    function(`z=>z`)  

  def `w=>(z>-->w)`[W, Z]: W => (Z >--> W) = { w =>
    function(`w=>(z=>w)`(w))
  }     

  def `(y&&x)>-->(y&&x)`[Y, X]: (Y && X) >--> (Y && X) =
    function(`(y&&x)=>(y&&x)`)

  def `(z&&y)>-->z`[Z, Y]: (Z && Y) >--> Z =
    function(`(z&&y)=>z`)   

  def `(z&&y)>-->y`[Z, Y]: (Z && Y) >--> Y =
    function(`(z&&y)=>y`)

  def `(u&&y)>-->y`[Y]: (Unit && Y) >--> Y =
    `(z&&y)>-->y` 

  def `((z&&y)&&x)>-->(y&&x)`[Z, Y, X]: ((Z && Y) && X) >--> (Y && X) =
    function(`((z&&y)&&x)=>(y&&x)`)      

  def `(z&&(y&&x))>-->z`[Z, Y, X]: (Z && (Y && X)) >--> Z =
    function(`(z&&(y&&x))=>z`) 

  def `(z&&(y&&x))>-->y`[Z, Y, X]: (Z && (Y && X)) >--> Y =
    function(`(z&&(y&&x))=>y`) 

  def `(z&&(y&&x))>-->x`[Z, Y, X]: (Z && (Y && X)) >--> X =
    function(`(z&&(y&&x))=>x`) 

  def `(y||x)>-->(y||x)`[Y, X]: (Y || X) >--> (Y || X) =
    function(`(y||x)=>(y||x)`)
    
  def `z>-->(z||y)`[Z, Y]: Z >--> (Z || Y) =
    function(`z=>(z||y)`)

  def `y>-->(z||y)`[Z, Y]: Y >--> (Z || Y) =
    function(`y=>(z||y)`)

  def `(w&&b)>-->(w||w)`[W]: (W && Boolean) >--> (W || W) =
    function(`(w&&b)=>(w||w)`)

  def `(y||x)>-->b`[Y, X]: (Y || X) >--> Boolean =
    function(`(y||x)=>b`)

  def `(y||x)>-->y`[Y, X]: (Y || X) >--> Y =
    function(`(y||x)=>y`)

  def `(y||x)>-->x`[Y, X]: (Y || X) >--> X =
    function(`(y||x)=>x`) 

  def `z>-->u`[Z]: Z >--> Unit =
    function(`z=>u`)           

  def readInt(message: String): Unit >--> BigInt =
    function(readIntFunction(message))

  def write[Y](message: String): Y >--> Unit =
    function(writeFunction(message))

}
