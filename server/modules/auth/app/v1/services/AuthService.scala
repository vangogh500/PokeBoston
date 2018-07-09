package v1
package services

import scala.concurrent.{Future}
import models.AuthServiceResponse
import sangria.macros.derive.{deriveContextObjectType, IncludeMethods}

/**
 * Defines an auth service
 */
trait AuthService {
  /**
   * Login business logic
   */
  def login(email: String, password: String): Future[AuthServiceResponse]
  /**
   * Registration business logic.
   */
  def register(email: String, password: String): Unit
}
