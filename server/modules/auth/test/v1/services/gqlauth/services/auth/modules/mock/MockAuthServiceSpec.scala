package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth
package modules.mock

import errors._
import scala.concurrent.ExecutionContext.Implicits.global
import org.scalatestplus.play._
import org.scalatestplus.play.guice._

class MockAuthServiceSpec extends PlaySpec with GuiceOneAppPerTest {
  "MockAuthService" must {
    "implement login" in {
      val service = app.injector.instanceOf[MockAuthService]
      service.login("test@test.com", "kBbq123$") map { result =>
        result.isInstanceOf[AuthServiceResponse] mustBe true
      }
    }
    "throws ClientSyntaxException when invalid email is used for login" in {
      val service = app.injector.instanceOf[MockAuthService]
      service.login("test", "kBbq123$").failed map { e =>
        e.isInstanceOf[ClientSyntaxException] mustBe true
      }
    }
    "throws ClientSyntaxException when invalid password is used for login" in {
      val service = app.injector.instanceOf[MockAuthService]
      service.login("test@test.com", "test").failed map { e =>
        e.isInstanceOf[ClientSyntaxException] mustBe true
      }
    }
    "future throws ClientAuthException with invalid credentials" in {
      val service = app.injector.instanceOf[MockAuthService]
      service.login("test2@test2.com", "kBbq123$").failed map { e =>
        e.isInstanceOf[ClientAuthException] mustBe true
      }
    }
    "implement register" in {
      val service = app.injector.instanceOf[MockAuthService]
      service.register("test@test.com", "kbbq") map { result =>
        result.isInstanceOf[AuthServiceResponse] mustBe true
      }
    }
    "throws ClientSyntaxException when invalid email is used for register" in {
      val service = app.injector.instanceOf[MockAuthService]
      a[ClientSyntaxException] mustBe thrownBy {
        service.register("test", "kbbq")
      }
    }
    "throws ClientSyntaxException when invalid password is used for register" in {
      val service = app.injector.instanceOf[MockAuthService]
      a[ClientSyntaxException] mustBe thrownBy {
        service.register("test@test.com", "test")
      }
    }
    "be able to use same credentials for login after register" in {
      val service = app.injector.instanceOf[MockAuthService]
      service.register("test@test.com", "kBbq123$") flatMap { regResult =>
        regResult.isInstanceOf[AuthServiceResponse] mustBe true
        service.login("test@test.com", "kBbq123$") map { logResult =>
          logResult.isInstanceOf[AuthServiceResponse] mustBe true
        }
      }
    }
  }
}
