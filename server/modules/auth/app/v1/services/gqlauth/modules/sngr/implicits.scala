package com.pokeboston.auth
package v1
package services
package gqlauth
package modules.sngr

import sangria.macros.derive.{deriveObjectType}
import sangria.schema.{ScalarType}
import sangria.validation.{ValueCoercionViolation}
import auth.{AuthService}
import auth.responses._

/**
 * Implicits needed for deriving sangria schema
 * @see https://sangria-graphql.org/learn/
 */
package object implicits {
  implicit val LoginResponseSchema = deriveObjectType[SangriaContext[Unit, AuthService], LoginResponse]()
  case object UnitCoercionViolation extends ValueCoercionViolation("Unit value expected")
  implicit val UnitType = ScalarType[Unit]("Unit",
    coerceOutput = {
      case _ => null
    },
    coerceUserInput = {
      case null => Right(null)
      case _ => Left(UnitCoercionViolation)
    },
    coerceInput = {
      case null => Right(null)
      case _ => Left(UnitCoercionViolation)
    }
  )
}
