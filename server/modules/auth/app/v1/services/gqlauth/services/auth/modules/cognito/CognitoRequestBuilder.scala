package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth
package modules.cognito

import javax.inject._
import lib.Builder
import com.amazonaws.services.cognitoidp.model.{AdminInitiateAuthRequest, AuthFlowType}

/**
 * Request builder for AWS Cognito
 * @see https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/cognitoidp/model/AdminInitiateAuthRequest.html
 *
 * @param clientId Client id
 * @param poolId Pool id
 */
@Singleton
case class CognitoRequestBuilder(clientId: String, poolId: String) extends Builder[AdminInitiateAuthRequest] {
  def build = new AdminInitiateAuthRequest()
    .withClientId(clientId)
    .withUserPoolId(poolId)
    .withAuthFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
}
