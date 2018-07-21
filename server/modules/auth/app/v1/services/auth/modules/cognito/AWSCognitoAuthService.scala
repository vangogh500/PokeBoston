package com.pokeboston.auth
package v1
package services
package auth
package modules.cognito

import javax.inject._
// implicits
import scala.concurrent.ExecutionContext
import scala.collection.JavaConverters._
import lib.native.JavaScalaInterop._
// specs
import builders._
import errors._
import validators._
import responses._
import challenges._
// models
import scala.util.{Success, Failure}
import com.amazonaws.services.cognitoidp.model.{UserNotFoundException, NotAuthorizedException, AttributeType}
//lib
import com.amazonaws.services.cognitoidp.{AWSCognitoIdentityProviderAsync}


/**
 * Implementation of auth service using AWS cognito.
 * @param cognitoClient CognitoClient used
 * @param reqBuilder Cognito client request builder
 */
@Singleton
class AWSCognitoAuthService @Inject()(cognitoClient: AWSCognitoIdentityProviderAsync, reqBuilders: CognitoReqBuilders)(implicit ec: ExecutionContext) extends AuthService {
  import reqBuilders._
  def login(email: String, password: String) = (email, password) match {
    case (EmailValidator(email), PasswordValidator(password)) =>
      val params = Map[String, String](
        "USERNAME" -> email,
        "PASSWORD" -> password
      )
      val req = AdminInitiateAuthReqBuilder.build.withAuthParameters(params.asJava)
      cognitoClient.adminInitiateAuthAsync(req).asScala transform {
        case Success(res) =>
          val awsAuthRes = res.getAuthenticationResult()
          Success(LoginResponse(
            idToken = awsAuthRes.getIdToken(),
            accessToken = awsAuthRes.getAccessToken(),
            refreshToken = awsAuthRes.getRefreshToken(),
            challenge = res.getChallengeName() match {
              case "SMS_MFS" => SmsMfaChallenge
              case str => NilChallenge
            }
          ))
        case Failure(e) => e match {
          case e: UserNotFoundException => Failure(ClientAuthException(e.getMessage()))
          case e: NotAuthorizedException => Failure(ClientAuthException(e.getMessage()))
          case _ => Failure(ServerException(e.getMessage()))
        }
      }
    case _ => throw ClientSyntaxException("email or password is not of valid syntax")
  }

  def register(email: String, password: String) = (email, password) match {
    case (EmailValidator(email), PasswordValidator(password)) =>
      val req = SignUpReqBuilder.build
        .withUsername(email)
        .withPassword(password)
        .withUserAttributes(Seq(
          new AttributeType().withName("email").withValue(email)
        ).asJava)
        cognitoClient.signUpAsync(req).asScala.map { res =>
          if(res.isUserConfirmed()) RegisterResponse(EmailVerificationChallenge)
          else RegisterResponse()
        }
    case _ => throw ClientSyntaxException("Invalid email or password syntax")
  }
}
