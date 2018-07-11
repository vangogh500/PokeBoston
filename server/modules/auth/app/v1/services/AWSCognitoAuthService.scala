package v1
package services

import javax.inject._
// implicits
import scala.concurrent.ExecutionContext
import lib.native.JavaScalaInterop._
import scala.collection.JavaConverters._
// models
import scala.util.{Success, Failure}
import scala.concurrent.Future
import models.errors._
import models.AuthServiceResponse
import com.amazonaws.services.cognitoidp.model.{AdminInitiateAuthRequest, AuthFlowType, UserNotFoundException, NotAuthorizedException}
import com.amazonaws.services.cognitoidp.{AWSCognitoIdentityProviderAsync}

/**
 * Implementation of auth service using AWS cognito.
 * @param cognitoClient CognitoClient wrapper used
 */
@Singleton
class AWSCognitoAuthService @Inject()(cognitoClient: AWSCognitoIdentityProviderAsync)(implicit ec: ExecutionContext) extends AuthService {
  def login(email: String, password: String) = {
    val params = Map[String, String](
      "USERNAME" -> email,
      "PASSWORD" -> password
    )
    val req = new AdminInitiateAuthRequest()
      .withClientId("7q65cifvqaedpman6mi8pvk18h")
      .withUserPoolId("us-east-1_qiIUxYjmN")
      .withAuthFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
      .withAuthParameters(params.asJava)

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
