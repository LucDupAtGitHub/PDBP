package pdbp.utils

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