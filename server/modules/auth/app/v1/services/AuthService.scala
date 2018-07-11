package v1
package services

import sangria.macros.derive._
import scala.concurrent.{Future}
import models.AuthServiceResponse

/**
 * Defines an auth service
 */
trait AuthService {
  /**
   * Login business logic
   * @param email Email
   * @param password Password
   */
  @GraphQLField
  def login(email: String, password: String): Future[AuthServiceResponse]
  /**
   * Registration business logic.
   * @param email Email
   * @param password Password
   */
  @GraphQLField
  def register(email: String, password: String): Future[AuthServiceResponse]
}
