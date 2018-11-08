package db

import com.outworkers.phantom.dsl._

class TokensDatabase(override val connector: CassandraConnection) extends Database[TokensDatabase](connector) {
   object Tokens  extends TokensStore with Connector
}