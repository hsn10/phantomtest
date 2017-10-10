package dao

import com.outworkers.phantom.dsl._

import model.User
import db.Users
import model.LoginInfo

import scala.concurrent.Future

abstract class UsersStore extends Users {

  def save(u: User) = {
     insert
        .value(_.email, u.email)
        .value(_.firstName, u.firstName)
        .value(_.fullName, u.fullName)
        .value(_.avatarURL, u.avatarURL)
     .future()
  }

  def get(email: String) : Future[Option[User]] = {
     select
        .where(_.email eqs email)
        .one()
  }

  def get(login: LoginInfo) : Future[Option[User]] = {
     select
        .where(_.loginInfo contains login)
        .allowFiltering
        .one()
  }
}