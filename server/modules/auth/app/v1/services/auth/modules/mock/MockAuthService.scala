package com.pokeboston.auth
package v1
package services
package auth
package modules.mock

import javax.inject._
// implicits
import scala.concurrent.ExecutionContext
import scala.collection.JavaConverters._
import lib.native.JavaScalaInterop._
// specs
import errors._
import responses._
import challenges._
// models
import scala.util.{Success, Failure}
//lib
import scala.concurrent.Future

/**
 * Implementation of auth service using mock (works offline)
 */
@Singleton
class MockAuthService @Inject()(implicit ec: ExecutionContext) extends AuthService {
  def login(email: String, password: String) = Future {
    AuthServiceLoginResponse(
      idToken = "hello",
      accessToken = "test",
      refreshToken = "test"
    )
  }

  def register(email: String, password: String) = (email, password) match {
    case (EmailValidator(email), PasswordValidator(password)) => 
      Future {
        MockDB.users.add(MockUser(email, password))
        AuthServiceRegistrationResponse()
      }
    case _ =>
      Future {
          throw ClientSyntaxException()
      }
  }

  def unregister(email: String, password: String) = Future {
    case (EmailValidator(email), PasswordValidator(password)) => 
      Future {
        MockDB.users.remove(MockUser(email, password))
        AuthServiceUnregistrationResponse()
      }
    case _ =>
      Future {
          throw ClientSyntaxException()
      }
  }
}
