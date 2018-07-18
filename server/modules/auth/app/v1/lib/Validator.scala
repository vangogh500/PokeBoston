package com.pokeboston.auth
package v1.lib

/**
 * Defines a validator type
 * @tparam T Type the validator validates
 */
trait Validator[T] {
  /**
   * Logic for validating T
   */
  def validate(that: T): Boolean
}
