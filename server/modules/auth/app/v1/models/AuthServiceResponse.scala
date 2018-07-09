package v1
package models

import gql.GQLObjectable
import sangria.macros.derive.{deriveObjectType}

/**
 * Defines a response from an auth service.
 * @see services.AuthService
 */
case class AuthServiceResponse(accessToken: Option[String], refreshToken: Option[String])

/**
 * Companion object for AuthServiceResponse
 */
object AuthServiceResponse {}
