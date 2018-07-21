package com.pokeboston.auth
package v1
package services
package auth
package modules
package mock

import responses._
import errors._
import scala.concurrent.ExecutionContext.Implicits.global
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import org.scalatest.concurrent.ScalaFutures

class MockAuthServiceSpec extends PlaySpec with GuiceOneAppPerSuite with AuthServiceBehaviors {
  "MockAuthService" must {
    behave like authService(app.injector.instanceOf[MockAuthService])
  }
}
