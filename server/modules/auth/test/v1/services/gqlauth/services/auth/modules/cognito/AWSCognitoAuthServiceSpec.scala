package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth
package modules.cognito

import errors._
import scala.concurrent.ExecutionContext.Implicits.global
import org.scalatestplus.play._
import org.scalatestplus.play.guice._

class AWSCognitoAuthServiceSpec extends PlaySpec with GuiceOneAppPerTest {
  "AWSCognitoAuthService" must {
    "implement login" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      service.login("test@test.com", "kBbq123$") map { result =>
        result.isInstanceOf[AuthServiceResponse] mustBe true
      }
    }
    "throws ClientSyntaxException when invalid email is used for login" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      a[ClientSyntaxException] mustBe thrownBy {
        service.login("test", "kBbq123$")
      }
    }
    "throws ClientSyntaxException when invalid password is used for login" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      a[ClientSyntaxException] mustBe thrownBy {
        service.login("test@test.com", "test")
      }
    }
    "future throws ClientAuthException with invalid credentials" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      service.login("test2@test2.com", "kBbq123$").failed map { e =>
        e.isInstanceOf[ClientAuthException] mustBe true
      }
    }
    "implement register" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      service.register("test@test.com", "kbbq") map { result =>
        result.isInstanceOf[AuthServiceResponse] mustBe true
      }
    }
    "throws ClientSyntaxException when invalid email is used for register" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      a[ClientSyntaxException] mustBe thrownBy {
        service.register("test", "kbbq")
      }
    }
    "throws ClientSyntaxException when invalid password is used for register" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      a[ClientSyntaxException] mustBe thrownBy {
        service.register("test@test.com", "test")
      }
    }
    "be able to use same credentials for login after register" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      service.register("test@test.com", "kBbq123$") flatMap { regResult =>
        regResult.isInstanceOf[AuthServiceResponse] mustBe true
        service.login("test@test.com", "kBbq123$") map { logResult =>
          logResult.isInstanceOf[AuthServiceResponse] mustBe true
        }
      }
    }
  }
}
