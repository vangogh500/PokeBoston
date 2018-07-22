package com.pokeboston.auth
package v1
package services
package auth

import play.api.libs.json.JsValue
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
  def login(email: String, password: String): Future[AuthServiceLoginResponse]

  /**
   * Registration business logic.
   * @param email Email
   * @param password Password
   * @throws ClientSyntaxException If email or password syntax is incorrect
   * @throws ClientAuthException If supplied authorization is not valid
   * @throws ServerException If server fails to authorize credentials
   */
  @GraphQLField
  def register(email: String, password: String): Future[AuthServiceRegistrationResponse]

  /**
   * Unregistration business logic.
   * @param email Email
   * @param password Password
   * @throws ClientSyntaxException If email or password syntax is incorrect
   * @throws ClientAuthException If supplied authorization is not valid
   * @throws ServerException If server fails to authorize credentials
   */
  @GraphQLField
  def unregister(email: String, password: String): Future[AuthServiceUnregistrationResponse]

  /**
   * Login using request body
   * @param reqBody Request body
   * @throws ClientSyntaxException If email or password syntax is incorrect
   * @throws ClientAuthException If supplied authorization is not valid
   * @throws ServerException If server fails to authorize credentials
   */
  def login(reqBody: JsValue): Future[AuthServiceLoginResponse] = login(
      (reqBody \ "email").asOpt[String] getOrElse "",
      (reqBody \ "password").asOpt[String] getOrElse ""
  )

  /**
   * Register using request body
   * @param reqBody Request body
   * @throws ClientSyntaxException If email or password syntax is incorrect
   * @throws ClientAuthException If supplied authorization is not valid
   * @throws ServerException If server fails to authorize credentials
   */
  def register(reqBody: JsValue): Future[AuthServiceRegistrationResponse] = register(
      (reqBody \ "email").asOpt[String] getOrElse "",
      (reqBody \ "password").asOpt[String] getOrElse ""
  )

  /**
   * Unregister using request body
   * @param reqBody Request body
   * @throws ClientSyntaxException If email or password syntax is incorrect
   * @throws ClientAuthException If supplied authorization is not valid
   * @throws ServerException If server fails to authorize credentials
   */
  def unregister(reqBody: JsValue): Future[AuthServiceUnregistrationResponse] = unregister(
      (reqBody \ "email").asOpt[String] getOrElse "",
      (reqBody \ "password").asOpt[String] getOrElse ""
  )
}
