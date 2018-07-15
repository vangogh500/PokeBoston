package com.pokeboston.auth
package v1
package services
package gqlauth

import lib.Builder
import services.auth.{AuthService}

/**
 * Defines a GQL service builder
 */
trait GQLAuthServiceBuilder {
  /**
   * Builds a gql service from an auth service
   * @param authService Auth service to use
   */
  def build(authService: AuthService): GQLAuthService
}
