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

object runUtils {

  def readIntFunction(message: String): Unit => BigInt = { _ =>
    println(s"$message")
    val i = BigInt(scala.io.StdIn.readInt())
    i
  }

  def writeFunction[Y](message: String): Y => Unit = { y =>
    print(s"$message ")
    val u = println(s"$y")
    u
  }

}