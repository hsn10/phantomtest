package db

import com.outworkers.phantom.dsl._

import java.util.UUID

abstract class TokensStore extends TokensTable {
   def save(t: Token) = {
      insert
        .value(_.email, t.email)
        .value(_.token, t.token)
        .value(_.counter, t.counter)
      .future()
   }
   def get(id : UUID) = {
      select.where( _.token eqs id).one()
   }
   def expired(counter : Int) = {
      /* PHANTOM BUG: With "allow filtering" cassandra allows to query
       * non indexed column. Some restrictions depending on Cassandra 
       * 3.X sub version are on querying part of partitioning
       * multi column key.
       */
      select.where( _.counter gte counter).allowFiltering().fetch()
   }
}