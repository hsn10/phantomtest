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
      /* PHANTOM NOT IMPLEMENTED FEATURE:
       * With "allow filtering" cassandra allows to query
       * non indexed column. Restrictions are on querying part of multi column
       * partition key. You need Cassandra 3.10+ to be able to filter
       * on partition key columns.
       */
      select.where( _.counter gte counter).allowFiltering().fetch()
   }
}