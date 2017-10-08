/**
 * In this example we will create a simple table storing recipes.
 */
package model

import java.time._

case class Recipe(
 id: Int,
 name: String,
 title: String,
 author: String,
 description: String,
 ingredients: Set[String],
 props: Map[String, String],
 timestamp: LocalDateTime
)
