package db

import org.scalatest.concurrent.ScalaFutures._
import org.scalatest.Matchers._
import com.outworkers.phantom.dsl._
import org.scalatest._
import scala.concurrent.duration._

import model.LoginInfo

class DatabaseSpec extends PhantomSuite {

  Console.println(database.Passwords.create.ifNotExists.qb.queryString)

  override def beforeAll(): Unit = {
    super.beforeAll()

    database.create(1.minute)
  }

  override def afterAll(): Unit = {
    super.afterAll()
    database.drop(1.minute)
  }

  "Project database" should {
    "create cassandra tables" in {

       // if table reads return no error, we should assume that table exist
       whenReady ( database.Passwords.get(LoginInfo("1", "2")) ) { case res =>
          res should be eq (None)
       }
    }
  }
}
