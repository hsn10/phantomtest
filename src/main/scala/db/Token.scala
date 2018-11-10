package db

import java.util.UUID

final case class Token(email: String, token: UUID, counter : Int)