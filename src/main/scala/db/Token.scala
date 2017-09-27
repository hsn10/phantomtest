package db

import java.util.UUID

case class Token(email: String, token: UUID, counter : Int)