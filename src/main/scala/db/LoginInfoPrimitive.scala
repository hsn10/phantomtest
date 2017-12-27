package db

import com.outworkers.phantom.builder.primitives._
import model.LoginInfo

object LoginInfoPrimitive {
   implicit val conversion : Primitive[LoginInfo] = {
      Primitive.derive[LoginInfo, Tuple2[String, String]] ( x /*: LoginInfo*/ => x.providerID -> x.providerKey )( x =>
        { val ( a, b ) = x;
          LoginInfo(a, b)
        })
   }
}