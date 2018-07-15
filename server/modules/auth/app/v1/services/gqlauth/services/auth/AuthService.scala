package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth

import scala.concurrent.ExecutionContext
import sangria.macros.derive._
import scala.concurrent.{Future}

/**
 * Defines an auth service specification for v1
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
