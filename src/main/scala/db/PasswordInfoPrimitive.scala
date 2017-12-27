package db

import com.outworkers.phantom.builder.primitives._
import model.PasswordInfo

object PasswordInfoPrimitive {
   implicit val conversion : Primitive[PasswordInfo] = {
      Primitive.derive[PasswordInfo, (String, String, Option[String])]( pi => ( pi.hasher, pi.password, pi.salt ))( x =>
         { val ( a, b, c ) = x
           PasswordInfo(a, b, c)
         }
      )
   }
}