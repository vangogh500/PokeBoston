package com.pokeboston.auth
package v1
package services
package gqlauth
package modules.sngr

import sangria.macros.derive.{deriveObjectType}
import auth.{AuthService}
import auth.responses._

/**
 * Implicits needed for deriving sangria schema
 * @see https://sangria-graphql.org/learn/
 */
package object implicits {
  implicit val loginResponseSchema = deriveObjectType[SangriaContext[Unit, AuthService], LoginResponse]()
}
