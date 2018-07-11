package v1
package models
package sngql

import services.AuthService

/**
 * Implicits needed for deriving sangria schema
 * @see https://sangria-graphql.org/learn/
 */
package object implicits {
  implicit val responseSchema = AuthServiceResponse.asSangriaObject[SangriaContext[Unit, AuthService]]
}
