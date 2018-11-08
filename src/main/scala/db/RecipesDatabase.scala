package db

import com.outworkers.phantom.dsl._

class RecipesDatabase(override val connector: CassandraConnection) extends Database[RecipesDatabase](connector) {
   object Tokens  extends TokensStore with Connector
}