package com.pokeboston.auth
package v1.lib

import play.api.libs.json.JsValue

/**
 * Defines a type that can also be represented as a JSValue
 */
trait JsValuable {
  /**
   * Value as JsValue
   */
  def asJsValue: JsValue

  /**
   * Value as js formatted string
   */
  def asJsonString: String
}
