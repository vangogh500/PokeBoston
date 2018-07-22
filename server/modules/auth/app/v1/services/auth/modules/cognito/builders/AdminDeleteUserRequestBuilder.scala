package com.pokeboston.auth
package v1
package services
package auth
package modules.cognito
package builders

import javax.inject._
import lib.Builder
import com.amazonaws.services.cognitoidp.model.{AdminDeleteUserRequest}

/**
 * AdminInitiateAuthRequest builder for AWS Cognito
 * @see https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/cognitoidp/model/AdminInitiateAuthRequest.html
 *
 * @param clientId Client id
 * @param poolId Pool id
 */
case class AdminDeleteUserRequestBuilder(poolId: String) extends Builder[AdminDeleteUserRequest] {
  def build = new AdminDeleteUserRequest()
    .withUserPoolId(poolId)
}
