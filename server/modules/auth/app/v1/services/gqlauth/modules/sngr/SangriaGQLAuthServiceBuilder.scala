package com.pokeboston.auth
package v1
package services
package gqlauth
package modules.sngr

import javax.inject._
import services.auth.AuthService

/**
 * Implementation of GQL service builder using Sangria
 */
object SangriaGQLAuthServiceBuilder extends GQLAuthServiceBuilder {
  /**
   * Creates an instance of a GQL service implemented using Sangria
   * @param authService Auth service to use
   */
  def build(authService: AuthService) = SangriaGQLAuthService(authService)
}
