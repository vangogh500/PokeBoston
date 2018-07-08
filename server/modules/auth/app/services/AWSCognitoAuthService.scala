package services

import javax.inject._

import lib.native.JavaScalaInterop
import lib.aws.CognitoClient

import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.JavaConverters._
import com.amazonaws.services.cognitoidp.model.{AdminInitiateAuthRequest, AuthFlowType}

/**
 * Implementation of auth service using AWS cognito.
 * @param cognitoClient CognitoClient wrapper used
 */
@Singleton
class AWSCognitoAuthService @Inject()(cognitoClient: CognitoClient) extends AuthService {
  def login(email: String, password: String) {
    val params = Map[String, String](
      "USERNAME" -> email,
      "PASSWORD" -> password
    )
    val req = new AdminInitiateAuthRequest()
      .withClientId("7q65cifvqaedpman6mi8pvk18h")
      .withUserPoolId("us-east-1_qiIUxYjmN")
      .withAuthFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
      .withAuthParameters(params.asJava)

    val result = cognitoClient.adminInitiateAuthAsync(req) onComplete {
      case Success(msg) => println(msg)
      case Failure(msg) => println(msg)
    }
  }

  def register(email: String, password: String) {

  }
}
