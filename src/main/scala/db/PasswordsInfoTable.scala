package db

import com.outworkers.phantom.dsl._

import model.PasswordInfo
import model.LoginInfo

import model.LinkedPasswordInfo
import dao.PasswordsInfoStore

abstract class PasswordsInfoTable extends Table[PasswordsInfoStore, LinkedPasswordInfo] {
   override val tableName = "passwords"
   object login extends Col[LoginInfo] with PartitionKey
   object password extends Col[PasswordInfo]
}