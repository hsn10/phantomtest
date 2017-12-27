package db

import com.outworkers.phantom.dsl._
import org.scalatest._
import scala.concurrent.duration._

abstract class PhantomSuite extends WordSpec with DatabaseProvider[Database] with BeforeAndAfterAll {
  override val database = new Database(ContactPoint.embedded.keySpace("my_app_test"))

  override def beforeAll(): Unit = {
    super.beforeAll()
    database.create(1.minute)
  }

  override def afterAll(): Unit = {
    super.afterAll()
    database.drop(1.minute)
  }
}