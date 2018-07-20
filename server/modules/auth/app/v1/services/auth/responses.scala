package com.pokeboston.auth
package v1
package services
package auth

package object responses {
  sealed trait AuthServiceResponse
  /**
   * Defines a response from an auth service for v1
   * @see services.AuthService
   * @param accessToken Access token
   * @param refreshToken Refresh token
   */
  case class LoginResponse(accessToken: Option[String], refreshToken: Option[String]) extends AuthServiceResponse
}
