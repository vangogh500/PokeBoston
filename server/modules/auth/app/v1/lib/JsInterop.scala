package com.pokeboston.auth
package v1.lib

import play.api.libs.json.JsValue

/**
 * Defines a JS interop type
 * @tparam T Type the interop interops with
 */
trait JsInterop[T] {
  /**
   * Logic for interoping type T from string
   */
  def apply(that: String): T
  /**
   * Logic for interoping type T from JSValue
   */
  def apply(that: JsValue): T
}
