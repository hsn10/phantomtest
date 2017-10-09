package db

import com.outworkers.phantom.dsl._

import model.PasswordInfo
import model.LoginInfo

import model.LinkedPasswordInfo
import dao.PasswordsInfoStore

abstract class PasswordsInfoTable extends Table [PasswordsInfoStore, LinkedPasswordInfo] {
   implicit protected val c1 = PasswordInfoPrimitive.conversion
   implicit protected val c2 = LoginInfoPrimitive.conversion
   object password extends Col[PasswordInfo] {
      override val name = "p"
   }
   object login extends Col[LoginInfo] with PartitionKey
}