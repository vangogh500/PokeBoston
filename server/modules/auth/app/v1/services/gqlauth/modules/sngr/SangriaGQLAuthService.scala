package com.pokeboston.auth
package v1
package services
package gqlauth
package modules.sngr

import sangria.marshalling.playJson._
import scala.util.{Success, Failure}
import scala.concurrent.{Future, ExecutionContext}
import play.api.libs.json._
import sangria.execution._
import sangria.parser.{SyntaxError, QueryParser}
import services.auth.AuthService

/**
 * Implementation of GQL service using Sangria
 * @param authService Auth service to use
 */
case class SangriaGQLAuthService(authService: AuthService) extends GQLAuthService(authService) {
  /**
   * Executes reqBody
   * @param reqBody Request body to execute
   * @param ec Execution context
   */
  def execute(reqBody: JsValue)(implicit ec: ExecutionContext) = {
    val query = (reqBody \ "query").as[String]
    val operation = (reqBody \ "operationName").asOpt[String]
    val variables = (reqBody \ "variables") match {
      case JsDefined(JsString(vars)) => vars.trim match {
        case "" => Json.obj()
        case _ => Json.parse(vars).as[JsObject]
      }
      case JsDefined(obj: JsObject) => obj
      case _ => Json.obj()
    }
    executeQuery(query, variables, operation)
  }
  /**
   * Executes gql
   * @param query GQL query string
   * @param variables GQL variables
   * @param operation Operation name
   * @param ec Execution context
   */
  def executeQuery(query: String, variables: JsObject, operation: Option[String])(implicit ec: ExecutionContext) = QueryParser.parse(query) match {
    case Success(queryAst) => Executor.execute(
      SangriaSchema(),
      queryAst,
      SangriaContext[Unit, AuthService](Unit, authService),
      operationName = operation,
      variables = variables,
      maxQueryDepth = Some(10),
      exceptionHandler = SangriaExceptionHandler())
    case Failure(e: SyntaxError) => Future {
      Json.obj(
        "syntaxError" -> e.getMessage,
        "locations" -> Json.arr(Json.obj(
          "line" -> e.originalError.position.line,
          "column" -> e.originalError.position.column
        ))
      )}
    case Failure(e) => throw e
  }
}
