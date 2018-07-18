package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth
package modules.cognito

import javax.inject._
// implicits
import scala.concurrent.ExecutionContext
import scala.collection.JavaConverters._
import lib.native.JavaScalaInterop._
// specs
import errors._
import validators._
// models
import scala.util.{Success, Failure}
import com.amazonaws.services.cognitoidp.model.{UserNotFoundException, NotAuthorizedException}
//lib
import scala.concurrent.Future
import com.amazonaws.services.cognitoidp.{AWSCognitoIdentityProviderAsync}


/**
 * Implementation of auth service using AWS cognito.
 * @param cognitoClient CognitoClient used
 * @param reqBuilder Cognito client request builder
 */
@Singleton
class AWSCognitoAuthService @Inject()(cognitoClient: AWSCognitoIdentityProviderAsync, reqBuilder: CognitoRequestBuilder)(implicit ec: ExecutionContext) extends AuthService {
  def login(email: String, password: String) = {
    if(!EmailValidator.validate(email)) Future { throw ClientSyntaxException("Invalid email") }
    if(!PasswordValidator.validate(password)) Future { throw ClientSyntaxException("Invalid password") }
    val params = Map[String, String](
      "USERNAME" -> email,
      "PASSWORD" -> password
    )
    val req = reqBuilder.build.withAuthParameters(params.asJava)

    cognitoClient.adminInitiateAuthAsync(req).asScala transform {
      case Success(res) =>
        val awsAuthRes = res.getAuthenticationResult()
        Success(AuthServiceResponse(
          accessToken = Some(awsAuthRes.getAccessToken()),
          refreshToken = Some(awsAuthRes.getRefreshToken())
        ))
      case Failure(e) => e match {
        case e: UserNotFoundException => Failure(ClientAuthException(e.getMessage()))
        case e: NotAuthorizedException => Failure(ClientAuthException(e.getMessage()))
        case _ => Failure(ServerException(e.getMessage()))
      }
    }
  }

  def register(email: String, password: String) = Future {
    AuthServiceResponse(
      accessToken = Some("test"),
      refreshToken = Some("test")
    )
  }
}
