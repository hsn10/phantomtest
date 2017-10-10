package db

import com.outworkers.phantom.dsl._
import model.User
import model.LoginInfo

import LoginInfoPrimitive.conversion
import dao.UsersStore

abstract class Users extends Table[UsersStore, User] {
   object email extends StringColumn with PartitionKey
   object loginInfo extends SetColumn[LoginInfo] with Index
   object firstName extends OptionalStringColumn
   object fullName  extends OptionalStringColumn
   object avatarURL extends OptionalStringColumn
}