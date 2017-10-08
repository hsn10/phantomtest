package db

import com.outworkers.phantom.dsl._

import java.util.UUID
import model.Token

abstract class TokensStore extends TokensTable {
   def save(t: Token) = {
      insert
        .value(_.email, t.email)
        .value(_.token, t.token)
        .value(_.counter, t.counter)
      .future()
   }
   def get(id : UUID) = {
      select
         .where( _.token eqs id)
      .one()
   }
   /*
   def expired(counter : Int) = {
      select
         .where( _.counter gte counter)
         .allowFiltering()
      .fetch()
   }   
   */
}