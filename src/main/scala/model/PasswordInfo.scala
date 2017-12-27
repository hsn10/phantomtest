package model

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

trait AuthInfo