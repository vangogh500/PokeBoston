package com.pokeboston.auth
package v1
package services
package auth

import lib.{JsInterop, JsValuable}
import play.api.libs.json.{JsValue, JsString}

/**
 * v1 challenge types
 */
package object challenges {
  /**
   * Auth challenge
   */
  sealed trait AuthServiceChallenge extends JsValuable {
    val asJsValue = JsString(this.toString)
    val asJsonString = this.toString
  }
  /**
   * Registration challenge
   */
  sealed trait AuthServiceRegisterChallenge extends AuthServiceChallenge
  /**
   * Login challenge
   */
  sealed trait AuthServiceLoginChallenge extends AuthServiceChallenge
  /**
   * Nil challenge type
   */
  case object NilChallenge extends AuthServiceRegisterChallenge with AuthServiceLoginChallenge
  /**
   * Email verification challenge
   */
  case object EmailVerificationChallenge extends AuthServiceRegisterChallenge

  /**
   * SMS based MFA challenge
   */
  case object SmsMfaChallenge extends AuthServiceLoginChallenge

  object AuthServiceLoginChallenge extends JsInterop[AuthServiceLoginChallenge] {
    def apply(that: String): AuthServiceLoginChallenge = that match {
      case SmsMfaChallenge.asJsonString => SmsMfaChallenge
      case _ => NilChallenge
    }
    def apply(that: JsValue): AuthServiceLoginChallenge = that match {
      case JsString(str) => AuthServiceLoginChallenge(str)
      case _ => throw new IllegalArgumentException()
    }
  }

  object AuthServiceRegisterChallenge extends JsInterop[AuthServiceRegisterChallenge] {
    def apply(that: String): AuthServiceRegisterChallenge = that match {
      case EmailVerificationChallenge.asJsonString => EmailVerificationChallenge
      case _ => NilChallenge
    }
    def apply(that: JsValue): AuthServiceRegisterChallenge = that match {
      case JsString(str) => AuthServiceRegisterChallenge(str)
      case _ => throw new Exception()
    }
  }
}
