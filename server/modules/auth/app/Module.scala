package com.pokeboston.auth

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import play.api.{Configuration, Environment}

import v1.services.gqlauth.{GQLAuthServiceBuilder}
import v1.services.gqlauth.modules.sngr.{SangriaGQLAuthServiceBuilder}
import v1.services.gqlauth.services.auth.{AuthService}
import v1.services.gqlauth.services.auth.modules.cognito.{AWSCognitoAuthService}

/**
 * Guice module for auth service.
 * @see https://www.schibsted.pl/blog/dependency-injection-play-framework-scala/
 */
class Module(environment: Environment, configuration: Configuration) extends AbstractModule {
  def configure() = {
    bind(classOf[AuthService])
      .to(classOf[AWSCognitoAuthService])

    bind(classOf[GQLAuthServiceBuilder])
      .toInstance(SangriaGQLAuthServiceBuilder)
  }
}
