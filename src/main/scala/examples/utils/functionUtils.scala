package examples.utils

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

object functionUtils {

  val isPositiveFunction: BigInt => Boolean = { i =>
    i > 0
  }

  val isZeroFunction: BigInt => Boolean = { i =>
    i == 0
  }

  val isOneFunction: BigInt => Boolean = { i =>
    i == 1
  }

  val subtractOneFunction: BigInt => BigInt = { i =>
    i - 1
  }

  val multiplyFunction: (BigInt && BigInt) => BigInt = { (i, j) =>
    i * j
  }

  def oneFunction[Z]: Z => BigInt = { z =>
    1
  }

  // val subtractTwoFunction: BigInt => BigInt = { i =>
  //   i - 2
  // }

  // val addFunction: (BigInt && BigInt) => BigInt = { (i, j) =>
  //   i + j
  // }

  // def zeroFunction[Z]: Z => BigInt = { z =>
  //   1
  // }

}
