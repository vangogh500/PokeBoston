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
  /**
   * Apply uses validate
   */
  def apply(that: T) = validate(that)
  /**
   * Unapply for pattern matching
   */
  def unapply(that: T) = if(validate(that)) Some(that) else None
}
