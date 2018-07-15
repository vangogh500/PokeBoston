package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth
package modules.cognito

import play.api.inject.{Module => PlayModule}
import play.api.{Configuration, Environment}

import com.amazonaws.services.cognitoidp.{AWSCognitoIdentityProviderAsyncClientBuilder, AWSCognitoIdentityProviderAsync}
import com.amazonaws.regions.{Regions}

/**
 * Play module definition for cognito auth service
 * @see https://www.schibsted.pl/blog/dependency-injection-play-framework-scala/
 */
class Module extends PlayModule {
  def bindings(environment: Environment, configuration: Configuration) = Seq(
    bind(classOf[CognitoRequestBuilder])
      .toInstance {
        val clientId = configuration.get[String]("aws.cognito.clientId")
        val poolId = configuration.get[String]("aws.cognito.poolId")
        CognitoRequestBuilder(clientId, poolId)
      },
    bind(classOf[AWSCognitoIdentityProviderAsync])
      .toInstance {
        val region = configuration.get[String]("aws.cognito.region") match {
          case _ => Regions.US_EAST_1
        }
        AWSCognitoIdentityProviderAsyncClientBuilder.standard().withRegion(region).build()
      }
  )
}
