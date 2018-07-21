package com.pokeboston.auth
package v1
package services
package auth

import challenges._

package object responses {
  /**
   * Defines a response from an auth service for v1
   * @see com.pokeboston.auth.v1.services.auth.AuthService
   */
  sealed trait AuthServiceResponse
  /**
   * Defines a login response from auth service v1
   * @see com.pokeboston.auth.v1.services.auth.AuthService
   * @param idToken Id token
   * @param accessToken Access token
   * @param refreshToken Refresh token
   * @param challenge Challenge type
   */
  case class AuthServiceLoginResponse(
    idToken: String,
    accessToken: String,
    refreshToken: String,
    challenge: AuthServiceLoginChallenge = NilChallenge
  ) extends AuthServiceResponse

  /**
   * Defines a registration response from auth service v1
   * @see com.pokeboston.auth.v1.services.auth.AuthService
   * @param challenge Challenge type
   */
  case class AuthServiceRegistrationResponse(challenge: AuthServiceRegistrationChallenge = NilChallenge) extends AuthServiceResponse
}
