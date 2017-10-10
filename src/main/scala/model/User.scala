package model

case class User ( 
    email: String, 
    loginInfo: Set[LoginInfo], 
    firstName: Option[String],
    fullName: Option[String],
    avatarURL: Option[String]
)  extends Identity

trait Identity