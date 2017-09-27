package db

import com.outworkers.phantom.dsl._

abstract class TokensStore extends TokensTable {
   def save(t: Token) = {
      insert
        .value(_.email, t.email)
        .value(_.token, t.token)
        .value(_.counter, t.counter)
        .future()
   }
}