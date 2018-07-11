package v1
package services

import scala.concurrent.{Future, ExecutionContext}
import play.api.libs.json.JsValue

/**
 * Defines a GQL service
 * @param authService Authorization service to use
 */
abstract class GQLService(authService: AuthService) {
  /**
   * GQL execution business logic
   * @param reqBody Request body to execute
   * @param ec Execution context
   */
  def execute(reqBody: JsValue)(implicit ec: ExecutionContext): Future[JsValue]
}
