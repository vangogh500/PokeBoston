package com.pokeboston.auth
package v1
package services
package auth
package modules
package cognito

import responses._
import errors._
import scala.concurrent.ExecutionContext.Implicits.global
import org.scalatestplus.play._
import org.scalatestplus.play.guice._

class AWSCognitoAuthServiceSpec extends PlaySpec with GuiceOneAppPerSuite with AuthServiceBehaviors {
  "AWSCognitoAuthService" must {
    behave like authService(app.injector.instanceOf[AWSCognitoAuthService])
  }
}
