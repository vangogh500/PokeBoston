package com.pokeboston.auth
package v1
package services
package gqlauth
package modules.sngr

import sangria.execution.{ExceptionHandler, HandledException}
import auth.errors._

/**
 * Sangria exception handler
 * @see https://sangria-graphql.org/learn/
 */
object SangriaExceptionHandler {
  /**
   * Creates an instance of a sangria exception handler
   */
  def apply() = ExceptionHandler {
    case (m, ClientSyntaxException(msg)) => HandledException(msg)
    case (m, ClientAuthException(msg)) ⇒ HandledException(msg)
    case (m, ServerException(msg)) ⇒ HandledException(msg)
  }
}
