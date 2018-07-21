package com.pokeboston.auth
package v1
package services
package auth

import responses._
import errors._
import scala.concurrent.ExecutionContext.Implicits.global
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import org.scalatest.concurrent.ScalaFutures

trait AuthServiceBehaviors { this: PlaySpec =>
  def authService(service: AuthService) {
    "implement login" in {
      service.login("test@test.com", "kBbq123$") map { result =>
        result.isInstanceOf[AuthServiceLoginResponse] mustBe true
      }
    }
    "throw ClientSyntaxException when invalid email is used for login" in {
      ScalaFutures.whenReady(service.login("test", "kBbq123$").failed) { e =>
        e.isInstanceOf[ClientSyntaxException] mustBe true
      }
    }
    "throw ClientSyntaxException when invalid password is used for login" in {
      ScalaFutures.whenReady(service.login("test@test.com", "test").failed) { e =>
        e.isInstanceOf[ClientSyntaxException] mustBe true
      }
    }
    "throw ClientAuthException with invalid credentials" in {
      ScalaFutures.whenReady(service.login("test2@test2.com", "kBbq123$").failed) { e =>
        e.isInstanceOf[ClientAuthException] mustBe true
      }
    }
    "implement register" in {
      service.register("test@test.com", "kBbq123$") map { result =>
        result.isInstanceOf[AuthServiceRegistrationResponse] mustBe true
      }
    }
    "throw ClientSyntaxException when invalid email is used for register" in {
      ScalaFutures.whenReady(service.register("test", "kBbq123$").failed) { e =>
        e.isInstanceOf[ClientSyntaxException] mustBe true
      }
    }
    "throw ClientSyntaxException when invalid password is used for register" in {
      ScalaFutures.whenReady(service.register("test@test.com", "test").failed) { e =>
        e.isInstanceOf[ClientSyntaxException] mustBe true
      }
    }
  }
}
