package db

import com.outworkers.phantom.dsl._
import model.Recipe

abstract class RecipeTable extends Table[RecipesStore, Recipe] {

  object id extends  IntColumn with PartitionKey {
    override lazy val name = "the_primary_key"
  }

  // Now we define a column for each field in our case class.
  object name extends StringColumn
  object title extends StringColumn
  object author extends StringColumn
  object description extends StringColumn

  // Custom data types can be stored easily.
  // Cassandra collections target a small number of items, but usage is trivial.
  object ingredients extends SetColumn[String]

  object props extends MapColumn[String, String]

  object timestamp extends DateTimeColumn
}