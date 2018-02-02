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

object functionUtils {

  def `z=>z`[Z]: Z => Z = { z =>
    z
  }

  def `mz=>mz`[M[+ _], Z]: M[Z] => M[Z] = { mz =>
    mz
  }  

  def `z=>u`[Z]: Z => Unit = { z =>
    ()
  }

  import pdbp.types.active.activeTypes._

  def `z=>az`[Z]: Z => Active[Z] = { z =>
    z
  }  

  def `m=>m`[M]: M => M = { m =>
    m
  }  

  def `w=>(z=>w)`[W, Z]: W => (Z => W) = { w =>
    _ =>
      w
  }  

}