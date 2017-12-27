package dao

import scala.concurrent.Future

import db.PasswordsInfoTable
import model.LinkedPasswordInfo
import model.LoginInfo

import com.outworkers.phantom.dsl._

abstract class PasswordsInfoStore extends PasswordsInfoTable {
   def get(l: LoginInfo) : Future[Option[LinkedPasswordInfo]] = {
      select
         .where(_.login eqs l)
         .one()
   }
   def save(p: LinkedPasswordInfo) : Future[ResultSet] = {
      insert
         .value(_.login, p.loginInfo)
         .value(_.password, p.passwordInfo)
         .future()
   }
   def delete(l: LoginInfo) : Future[ResultSet] = {
      delete()
         .where(_.login eqs l)
         .future()    
   }
}