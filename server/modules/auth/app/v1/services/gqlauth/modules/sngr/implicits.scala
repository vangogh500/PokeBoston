package com.pokeboston.auth
package v1
package services
package gqlauth
package modules.sngr

import sangria.macros.derive.{deriveObjectType}
import services.auth.{AuthService, AuthServiceResponse}

/**
 * Implicits needed for deriving sangria schema
 * @see https://sangria-graphql.org/learn/
 */
package object implicits {
  implicit val responseSchema = deriveObjectType[SangriaContext[Unit, AuthService], AuthServiceResponse]()
}
