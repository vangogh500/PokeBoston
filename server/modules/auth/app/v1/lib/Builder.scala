package com.pokeboston.auth
package v1.lib

/**
 * Defines a builder type
 * @tparam T Type the builder builds
 */
trait Builder[T] {
  /**
   * Logic for building T
   */
  def build: T
}
