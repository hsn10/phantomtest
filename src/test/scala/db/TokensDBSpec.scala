package db

import org.scalatest.concurrent.ScalaFutures._
import org.scalatest.Matchers._

class RecipesDBSpec extends PhantomSuite {
    "Recipe database" should {
        "create cassandra tables" in {
           // if table reads return no error, we should assume that table exist
           whenReady ( database.Recipes.findRecipeById(3) ) { case res =>
              res should be eq (None)
           }
        }
    }
}