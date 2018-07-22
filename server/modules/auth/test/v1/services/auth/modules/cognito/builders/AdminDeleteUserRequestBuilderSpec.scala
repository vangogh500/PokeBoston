package com.pokeboston.auth
package v1
package services
package auth
package modules.cognito
package builders

import com.amazonaws.services.cognitoidp.model.{AdminDeleteUserRequest}
import org.scalatestplus.play._

class AdminDeleteUserRequestBuilderSpec extends PlaySpec {
  "AdminDeleteUserRequestBuilder" must {
    "build an AdminDeleteUserRequest" in {
      val builder = AdminDeleteUserRequestBuilder("a")
      builder.build.isInstanceOf[AdminDeleteUserRequest] mustBe true
    }
    "use poolId in building request" in {
      val req = AdminDeleteUserRequestBuilder("a").build
      req.getUserPoolId() mustBe "a"
    }
  }
}
