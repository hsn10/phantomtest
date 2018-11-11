package db

import org.scalatest.concurrent.ScalaFutures._
import org.scalatest.Matchers._
import java.util.UUID

class TokensDBSpec extends PhantomSuite {
    "Tokens database" should {
        "create cassandra tables" in {
           // if table reads return no error, we should assume that table exist
           whenReady ( database.Tokens.get(UUID.randomUUID()) ) { case res =>
              res should be eq (None)
           }
        }
    }
}