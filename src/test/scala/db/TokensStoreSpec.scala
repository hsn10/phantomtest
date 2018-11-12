package db

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import org.scalatest.concurrent.ScalaFutures._
import org.scalatest.Matchers._

import java.util.UUID

class TokensStoreSpec extends PhantomSuite {
    "TokensStore" should {
        "store token and get it" in {
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
        "delete token" in {
           val t = Token("test2@email.com", UUID.randomUUID(), 1)
           val chain =
           for { save   <- database.Tokens.save(t)
                 load   <- database.Tokens.get(t.token)
                 delete <- database.Tokens.delete(t.token)
                 check  <- database.Tokens.get(t.token)
           }
           yield ( save, load, delete, check )

           whenReady ( chain ) { case ( rs1, ld1, rs2, ld2 ) =>
              rs1.wasApplied() shouldBe true
              ld1 should be eq (Some(t))
              rs2.wasApplied() shouldBe true
              ld2 shouldBe None
           }
        }
        "List expired tokens correctly" in {
           val t1 = Token("exptest1@email.com", UUID.randomUUID(), 2)
           val t2 = Token("exptest2@email.com", UUID.randomUUID(), 3)
           val t3 = Token("exptest3@email.com", UUID.randomUUID(), 4)
           val t4 = Token("exptest4@email.com", UUID.randomUUID(), 5)

           val f1 = database.Tokens.save(t1)
           val f2 = database.Tokens.save(t2)
           val f3 = database.Tokens.save(t3)
           val f4 = database.Tokens.save(t4)
           
           whenReady ( Future.sequence(Seq(f1,f2,f3,f4))) { _ =>
              whenReady ( database.Tokens.expired(4) ) { res =>
                 res should have size (2)
                 res should (contain(t3) and contain(t4))
              }
           }
        }
    }
}