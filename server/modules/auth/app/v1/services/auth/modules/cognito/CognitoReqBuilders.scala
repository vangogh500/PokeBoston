package com.pokeboston.auth
package v1
package services
package auth
package modules.cognito

import lib.Builder
import builders._
import javax.inject._
import com.amazonaws.services.cognitoidp.model.{AdminInitiateAuthRequest, AuthFlowType}

/**
 * AdminInitiateAuthRequest builder for AWS Cognito
 * @see https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/cognitoidp/model/AdminInitiateAuthRequest.html
 *
 * @param clientId Client id
 * @param poolId Pool id
 */
@Singleton
case class CognitoReqBuilders(clientId: String, poolId: String) {
  val AdminInitiateAuthReqBuilder = AdminInitateAuthRequestBuilder(clientId, poolId)
  val SignUpReqBuilder = SignUpRequestBuilder(clientId)
}
