package db

import scala.concurrent.ExecutionContext.Implicits.global

import org.scalatest.concurrent.ScalaFutures._
import org.scalatest.Matchers._

import java.util.UUID

class TokensStoreSpec extends PhantomSuite {
    "TokensStore" should {
        "store token" in {
           val t = Token("test@email.com", UUID.randomUUID(), 1)
           val chain =
           for { save <- database.Tokens.save(t)
                 load <- database.Tokens.get(t.token)
           }
           yield ( save, load )
              
           whenReady ( chain ) { case ( rs1, ld1 ) =>
              rs1.wasApplied() shouldBe true
              ld1 should be eq (Some(t))
           }
        }
    }
}