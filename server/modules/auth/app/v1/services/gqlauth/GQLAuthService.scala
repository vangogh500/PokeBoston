package com.pokeboston.auth
package v1
package services
package gqlauth

import auth.{AuthService}
import scala.concurrent.{Future, ExecutionContext}
import play.api.libs.json.JsValue

/**
 * Defines a GQL service for v1
 * @param authService Authorization service to use
 */
trait GQLAuthService {
  /**
   * GQL execution business logic
   * @param reqBody Request body to execute
   * @param ec Execution context
   */
  def execute(reqBody: JsValue)(implicit ec: ExecutionContext): Future[JsValue]
}
