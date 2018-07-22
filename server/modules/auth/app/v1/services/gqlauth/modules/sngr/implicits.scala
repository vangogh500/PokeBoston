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
   * AuthServiceLoginChallenge sangria rendering
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
   * AuthServiceRegistrationChallenge sangria rendering
   */
  implicit val AuthServiceRegistrationChallengeType = ScalarType[AuthServiceRegistrationChallenge]("AuthServiceRegistrationChallenge",
    coerceOutput = {
      case (challenge, _) => ast.StringValue(challenge.toString)
    },
    coerceUserInput = {
      case str: String => Right(AuthServiceRegistrationChallenge(str))
    },
    coerceInput = {
      case ast.StringValue(str, _, _, _, _) => Right(AuthServiceRegistrationChallenge(str))
    }
  )
  /**
   * AuthServiceUnregistrationChallenge sangria rendering
   */
  implicit val AuthServiceUnregistrationChallengeType = ScalarType[AuthServiceUnregistrationChallenge]("AuthServiceUnregisterChallenge",
    coerceOutput = {
      case (challenge, _) => ast.StringValue(challenge.toString)
    },
    coerceUserInput = {
      case str: String => Right(AuthServiceUnregistrationChallenge(str))
    },
    coerceInput = {
      case ast.StringValue(str, _, _, _, _) => Right(AuthServiceUnregistrationChallenge(str))
    }
  )
  /**
   * Login response sangria rendering
   */
  implicit val AuthServiceLoginResponseSchema = deriveObjectType[SangriaContext[Unit, AuthService], AuthServiceLoginResponse]()
  /**
   * Registration response sangria rendering
   */
  implicit val AuthServiceRegistrationResponseSchema = deriveObjectType[SangriaContext[Unit, AuthService], AuthServiceRegistrationResponse]()

  /**
   * Unregistration response sangria rendering
   */
  implicit val AuthServiceUnregistrationResponseSchema = deriveObjectType[SangriaContext[Unit, AuthService], AuthServiceUnregistrationResponse]()
}
