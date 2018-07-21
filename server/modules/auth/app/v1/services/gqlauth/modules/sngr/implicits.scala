package com.pokeboston.auth
package v1
package services
package gqlauth
package modules.sngr

import sangria.ast
import sangria.macros.derive.{deriveObjectType}
import sangria.schema.{ScalarType}
import sangria.validation.{ValueCoercionViolation}
import auth.{AuthService}
import auth.responses._
import auth.challenges._

/**
 * Implicits needed for deriving sangria schema
 * @see https://sangria-graphql.org/learn/
 */
package object implicits {
  case object AuthServiceChallengeCoercionViolation extends ValueCoercionViolation("AuthServiceChallenge value expected")
  /**
   * AuthServiceChallenge sangria rendering
   */
  implicit val AuthServiceLoginChallengeType = ScalarType[AuthServiceLoginChallenge]("AuthServiceLoginChallenge",
    coerceOutput = {
      case (challenge, _) => ast.StringValue(challenge.toString)
    },
    coerceUserInput = {
      case str: String => Right(AuthServiceLoginChallenge(str))
    },
    coerceInput = {
      case ast.StringValue(str, _, _, _, _) => Right(AuthServiceLoginChallenge(str))
    }
  )
  /**
   * AuthServiceChallenge sangria rendering
   */
  implicit val AuthServiceRegisterChallengeType = ScalarType[AuthServiceRegisterChallenge]("AuthServiceRegisterChallenge",
    coerceOutput = {
      case (challenge, _) => ast.StringValue(challenge.toString)
    },
    coerceUserInput = {
      case str: String => Right(AuthServiceRegisterChallenge(str))
    },
    coerceInput = {
      case ast.StringValue(str, _, _, _, _) => Right(AuthServiceRegisterChallenge(str))
    }
  )
  /**
   * Login response sangria rendering
   */
  implicit val LoginResponseSchema = deriveObjectType[SangriaContext[Unit, AuthService], LoginResponse]()
  /**
   * Register response sangria rendering
   */
  implicit val RegisterResponseSchema = deriveObjectType[SangriaContext[Unit, AuthService], RegisterResponse]()
}
