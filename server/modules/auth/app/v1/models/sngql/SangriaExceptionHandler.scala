package v1
package models
package sngql

import errors._
import sangria.execution.{ExceptionHandler, HandledException}

/**
 * Sangria exception handler
 * @see https://sangria-graphql.org/learn/
 */
object SangriaExceptionHandler {
  /**
   * Creates an instance of a sangria exception handler
   */
  def apply() = ExceptionHandler {
    case (m, ClientAuthException(msg)) ⇒ HandledException(msg)
    case (m, ServerException(msg)) ⇒ HandledException(msg)
  }
}
