package pdbp.utils

import pdbp.utils.productUtils._
import pdbp.utils.sumUtils._

object productAndSumUtils {

  // def foldBoolean[Z](tz: => Z, fz: => Z): Boolean => Z = {
  //   case true  => tz
  //   case false => fz    
  // } 

  // def `(w&&b)=>(w||w)`[W]: (W && Boolean) => (W || W) = { (w, b) =>
  //   foldBoolean[W || W](Left(w), Right(w))(b)
  // }

  def `(w&&b)=>(w||w)`[W]: (W && Boolean) => (W || W) = { (w, b) =>
    b match {
      case true  => Left(w)
      case false => Right(w)
    }
  }  

}
