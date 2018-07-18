package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth

import lib.Validator

/**
 * v1 validators
 */
package object validators {
  /**
   * v1 email validator
   */
  case object EmailValidator extends Validator[String] {
    private val regex = """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r
    def validate(that: String) = that match {
      case regex() => true
      case _ => false
    }
  }
  /**
   * v1 password validator
   * Requirements:
   * <ul>
   *  <li>At least 1 number</li>
   *  <li>At least 1 lowercase letter</li>
   *  <li>At least 1 uppercase letter</li>
   *  <li>At least 1 special character</li>
   *  <li>At least 8 characters long</li>
   * <ul>
   */
  case object PasswordValidator extends Validator[String] {
    private val regex = """^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$""".r
    def validate(that: String) = that match {
      case regex() => true
      case _ => false
    }
  }
}
