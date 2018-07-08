package v1
package models

/**
 * Defines a response from an auth service.
 * @see services.AuthService
 */
case class AuthServiceResponse(accessToken: Option[String], refreshToken: Option[String])
