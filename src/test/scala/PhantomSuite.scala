import com.outworkers.phantom.dsl._

import db.RecipesDatabase
import org.scalatest._
import scala.concurrent.duration._


abstract class PhantomSuite extends WordSpec with DatabaseProvider[RecipesDatabase] with BeforeAndAfterAll {
   override
   def database = new RecipesDatabase(ContactPoint.embedded.keySpace("my_app_test"))
   
   override
   def beforeAll(): Unit = {
      super.beforeAll()
      database.create(1.minute)
  }

   override
   def afterAll() = {
      super.afterAll()
      database.drop(1.minute)
   }
}