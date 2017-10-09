package db

import com.outworkers.phantom.dsl._
import scala.concurrent.{Future => ScalaFuture}
import dao.RecipesStore
import dao.TokensStore

// In this section, we will show how you can create a real-world Cassandra service with com.outworkers.phantom.
// First you have to think of what queries you need to perform. The usual.
// Say you come up with id and author.

// You will end up with several mapping tables enabling you to do all the queries you want.
// Now you are left with maintaining consistency at application level.
// We usually overlay a service on top of the mapping tables.
// To keep all the complexity away from other parts of the application.

class Database(override val connector: CassandraConnection) extends com.outworkers.phantom.dsl.Database[Database](connector) {

  object Recipes extends RecipesStore with Connector
  object Tokens  extends TokensStore with Connector
}