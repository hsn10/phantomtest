package db

import com.outworkers.phantom.dsl._
import org.scalatest._
import scala.concurrent.duration._


<<<<<<< HEAD
abstract class PhantomSuite extends WordSpec with DatabaseProvider[RecipesDatabase] with BeforeAndAfterAll {
  override val database = new RecipesDatabase(ContactPoint.embedded.keySpace("my_app_test"))

  override def beforeAll(): Unit = {
    super.beforeAll()
    database.create(1.minute)
=======
abstract class PhantomSuite extends WordSpec with DatabaseProvider[Database] with BeforeAndAfterAll {
   override
   def database = new Database(ContactPoint.embedded.keySpace("my_app_test"))
   
   override
   def beforeAll(): Unit = {
      super.beforeAll()
      database.create(1.minute)
>>>>>>> 0ac35edfb505ed592d04ec2e34795e2b05565097
  }

  override def afterAll() = {
    super.afterAll()
    database.drop(1.minute)
  }
}