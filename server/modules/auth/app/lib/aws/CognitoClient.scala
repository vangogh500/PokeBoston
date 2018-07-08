package lib.aws

import javax.inject._

import lib.native.JavaScalaInterop._
import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global
import com.amazonaws.services.cognitoidp.{AWSCognitoIdentityProviderAsync}
import com.amazonaws.services.cognitoidp.model.{AdminInitiateAuthRequest}

/**
 * Singleton wrapper for cognito client
 * @param client AWS cognito client to wrap
 */
@Singleton
class CognitoClient @Inject()(client: AWSCognitoIdentityProviderAsync) {
  def adminInitiateAuthAsync(req: AdminInitiateAuthRequest) = client.adminInitiateAuthAsync(req).asScala transform {
    case Success(res) => Success(res)
    case Failure(e) => Success(e)
  }
}
