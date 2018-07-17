package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth
package modules.cognito

import errors._
import scala.concurrent.ExecutionContext.Implicits.global
import com.amazonaws.services.cognitoidp.model.{AdminInitiateAuthRequest, AuthFlowType}
import org.scalatestplus.play._
import org.scalatestplus.play.guice._

class AWSCognitoAuthServiceSpec extends PlaySpec with GuiceOneAppPerTest {
  "AWSCognitoAuthService" must {
    "implement login" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      service.login("test@test.com", "kbbq") map { result =>
        result.isInstanceOf[AuthServiceResponse] mustBe true
      }
    }
    "throws ClientSyntaxException when invalid email is used for login" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      a[ClientSyntaxException] mustBe thrownBy {
        service.login("test", "kbbq")
      }
    }
    "implement register" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      service.register("test@test.com", "kbbq") map { result =>
        result.isInstanceOf[AuthServiceResponse] mustBe true
      }
    }
    "throws ClientSyntaxException when invalid email is used for login" in {
      val service = app.injector.instanceOf[AWSCognitoAuthService]
      a[ClientSyntaxException] mustBe thrownBy {
        service.register("test", "kbbq")
      }
    }
  }
}
