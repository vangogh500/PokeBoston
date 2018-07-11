package v1
package models

import sngql.{SangriaObjectable}
import sangria.macros.derive.{deriveObjectType}

/**
 * Defines a response from an auth service.
 * @see services.AuthService
 * @param accessToken Access token
 * @param refreshToken Refresh token
 */
case class AuthServiceResponse(accessToken: Option[String], refreshToken: Option[String])

/**
 * Companion object for AuthServiceResponse
 */
object AuthServiceResponse extends SangriaObjectable[AuthServiceResponse] {
  def asSangriaObject[Ctx] = deriveObjectType[Ctx, AuthServiceResponse]()
}
