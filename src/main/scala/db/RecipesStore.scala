package db

import scala.concurrent.{Future => ScalaFuture}
import com.outworkers.phantom.dsl._


abstract class RecipesStore extends RecipeTable {
    type UUID = Int

    def findRecipeById(id: UUID): ScalaFuture[Option[Recipe]] = {
    select.where(_.id eqs id).one()
  }

  // com.outworkers.phantom allows partial selects from any query.
  // this is currently limited to 22 fields.
  def findRecipeIngredients(id: UUID): ScalaFuture[Option[Set[String]]] = {
    select(_.ingredients).where(_.id eqs id).one()
  }

  // Because you are using a partition key, you can successfully using ordering
  // And you can paginate your records.
  // That's it, a really cool one liner.
  // The fetch method will collect an asynchronous lazy iterator into a Seq.
  // It's a good way to avoid boilerplate when retrieving a small number of items.
  def findRecipesPage(start: UUID, limit: Int): ScalaFuture[ListResult[Recipe]] = {
    select.where(_.id gtToken start).limit(limit).paginateRecord(_.setFetchSize(limit))
  }

  // Updating records is also really easy.
  // Updating one record is done like this
  def updateRecipeAuthor(id: UUID, author: String): ScalaFuture[ResultSet] = {
    update.where(_.id eqs id).modify(_.author setTo author).future()
  }

  // Updating records is also really easy.
  // Updating multiple fields at the same time is also easy.
  def updateRecipeAuthorAndName(id: UUID, name: String, author: String): ScalaFuture[ResultSet] = {
    update.where(_.id eqs id)
      .modify(_.name setTo name)
      .and(_.author setTo author)
      .future()
  }

  // Deleting records has the same restrictions and selecting.
  // If something is non primary, you cannot have it in a where clause.
  def deleteRecipeById(id: UUID): ScalaFuture[ResultSet] = {
    delete.where(_.id eqs id).future()
  }
}