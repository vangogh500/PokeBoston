package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth
package modules.cognito
package builders

import com.amazonaws.services.cognitoidp.model.{AdminInitiateAuthRequest, AuthFlowType}
import org.scalatestplus.play._

class AdminInitateAuthRequestBuilderSpec extends PlaySpec {
  "AdminInitateAuthRequestBuilder" must {
    "build an AdminInitiateAuthRequest" in {
      val builder = AdminInitateAuthRequestBuilder("a", "b")
      builder.build.isInstanceOf[AdminInitiateAuthRequest] mustBe true
    }
    "use clientId and poolId in building request" in {
      val req = AdminInitateAuthRequestBuilder("a", "b").build
      req.getClientId() mustBe "a"
      req.getUserPoolId() mustBe "b"
    }
  }
}
