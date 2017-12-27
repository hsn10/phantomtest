package model

import com.outworkers.phantom.builder.primitives.Primitive

trait AuthInfo

/**
 * The password details.
 *
 * @param hasher The ID of the hasher used to hash this password.
 * @param password The hashed password.
 * @param salt The optional salt used when hashing.
 */
case class PasswordInfo(
  hasher: String,
  password: String,
  salt: Option[String] = None
) extends AuthInfo

object PasswordInfo{
  implicit val conversion : Primitive[PasswordInfo] = {
    Primitive.derive[PasswordInfo, (String, String, Option[String])](pi => (pi.hasher, pi.password, pi.salt)) { x =>
      val (a, b, c) = x
      PasswordInfo(a, b, c)
    }
  }
}

