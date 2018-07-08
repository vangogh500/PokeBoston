import com.google.inject.AbstractModule
import com.google.inject.name.Names
import play.api.{Configuration, Environment}

import com.amazonaws.services.cognitoidp.{AWSCognitoIdentityProviderAsync, AWSCognitoIdentityProviderAsyncClientBuilder}
import com.amazonaws.regions.{Regions}

import services.{AuthService, AWSCognitoAuthService}

/**
 * Guice module for auth service.
 * @see https://www.schibsted.pl/blog/dependency-injection-play-framework-scala/
 */
class AuthModule(environment: Environment, configuration: Configuration) extends AbstractModule {
  def configure() = {
    bind(classOf[AWSCognitoIdentityProviderAsync])
      .toInstance(AWSCognitoIdentityProviderAsyncClientBuilder.standard().withRegion(Regions.US_EAST_1).build())

    bind(classOf[AuthService])
      .to(classOf[AWSCognitoAuthService])
  }
}
