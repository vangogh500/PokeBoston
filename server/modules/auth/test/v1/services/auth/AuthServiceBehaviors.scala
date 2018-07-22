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
import org.scalatest.time.{Seconds, Span}


trait AuthServiceBehaviors { this: PlaySpec =>
  implicit val defaultPatience = ScalaFutures.PatienceConfig(timeout = Span(1, Seconds))
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
    "implement unregister" in {
      service.unregister("test@test.com", "kBbq123$") map { result =>
        result.isInstanceOf[AuthServiceUnregistrationResponse] mustBe true
      }
    }
    "throw ClientSyntaxException when invalid email is used for unregister" in {
      ScalaFutures.whenReady(service.unregister("test", "kBbq123$").failed) { e =>
        e.isInstanceOf[ClientSyntaxException] mustBe true
      }
    }
    "throw ClientSyntaxException when invalid password is used for unregister" in {
      ScalaFutures.whenReady(service.unregister("test@test.com", "test").failed) { e =>
        e.isInstanceOf[ClientSyntaxException] mustBe true
      }
    }
    "pass simple auth flow" in {
      service.register("test@test.com", "kBbq123$") flatMap { registerRes =>
        registerRes.isInstanceOf[AuthServiceRegistrationResponse] mustBe true
        service.login("test@test.com", "kBbq123$") flatMap { loginRes =>
          loginRes.isInstanceOf[AuthServiceLoginResponse] mustBe true
          service.unregister("test@test.com", "kBbq123$") map { unregisterRes =>
            unregisterRes.isInstanceOf[AuthServiceUnregistrationResponse] mustBe true
          }
        }
      }
    }
  }
}
