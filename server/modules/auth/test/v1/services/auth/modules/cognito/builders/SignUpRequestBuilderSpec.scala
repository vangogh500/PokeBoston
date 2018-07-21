package com.pokeboston.auth
package v1
package services
package auth
package modules.cognito
package builders

import com.amazonaws.services.cognitoidp.model.{SignUpRequest}
import org.scalatestplus.play._

class SignUpRequestBuilderSpec extends PlaySpec {
  "SignUpRequestBuilder" must {
    val builder = SignUpRequestBuilder("a")
    "build an SignUpRequest" in {
      builder.build.isInstanceOf[SignUpRequest] mustBe true
    }
    "use clientId" in {
      val req = builder.build
      req.getClientId() mustBe "a"
    }
  }
}
