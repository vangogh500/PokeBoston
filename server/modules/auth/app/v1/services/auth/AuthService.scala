package com.pokeboston.auth
package v1
package services
package auth

import scala.concurrent.ExecutionContext
import sangria.macros.derive._
import scala.concurrent.{Future}
import responses._

/**
 * Defines an auth service specification for v1
 */
trait AuthService {
  /**
   * Login business logic
   * @param email Email
   * @param password Password
   * @throws ClientSyntaxException If email or password syntax is incorrect
   * @throws ClientAuthException If supplied authorization is not valid
   * @throws ServerException If server fails to authorize credentials
   */
  @GraphQLField
  def login(email: String, password: String): Future[LoginResponse]
  /**
   * Registration business logic.
   * @param email Email
   * @param password Password
   * @throws ClientSyntaxException If email or password syntax is incorrect
   * @throws ClientAuthException If supplied authorization is not valid
   * @throws ServerException If server fails to authorize credentials
   */
  @GraphQLField
  def register(email: String, password: String): Future[Int]
}
