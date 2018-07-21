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
  sealed trait AuthServiceRegistrationChallenge extends AuthServiceChallenge
  /**
   * Login challenge
   */
  sealed trait AuthServiceLoginChallenge extends AuthServiceChallenge
  /**
   * Nil challenge type
   */
  case object NilChallenge extends AuthServiceRegistrationChallenge with AuthServiceLoginChallenge
  /**
   * Email verification challenge
   */
  case object EmailVerificationChallenge extends AuthServiceRegistrationChallenge

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

  object AuthServiceRegistrationChallenge extends JsInterop[AuthServiceRegistrationChallenge] {
    def apply(that: String): AuthServiceRegistrationChallenge = that match {
      case EmailVerificationChallenge.asJsonString => EmailVerificationChallenge
      case _ => NilChallenge
    }
    def apply(that: JsValue): AuthServiceRegistrationChallenge = that match {
      case JsString(str) => AuthServiceRegistrationChallenge(str)
      case _ => throw new Exception()
    }
  }
}
