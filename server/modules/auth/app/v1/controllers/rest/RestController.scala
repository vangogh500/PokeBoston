package com.pokeboston.auth
package v1
package controllers
package rest

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.json._
import javax.inject._
import play.api._
import play.api.mvc._

import scala.util.{Success, Failure}
import services.gqlauth.{GQLAuthService}
import v1.services.auth.{AuthService}
import v1.services.auth.responses.{LoginResponse}
import v1.services.auth.errors._
import scala.concurrent.Future

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class RestController @Inject()(authService: AuthService) extends InjectedController {
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def login() = Action.async(parse.json) { request =>
    val body = request.body
    println(body)
    ((body \ "email").asOpt[String], (body \ "password").asOpt[String]) match {
      case (Some(email), Some(password)) =>
        authService.login((body \ "email").as[String], (body \ "password").as[String]) transform {
          case Success(LoginResponse(Some(accessToken), Some(refreshToken))) => Success(Ok(accessToken))
          case Failure(ClientSyntaxException(_)) => Success(BadRequest(""))
          case Failure(ClientAuthException(_)) => Success(Forbidden(""))
          case Failure(_) => Success(InternalServerError(""))
        }
      case _ => Future { BadRequest("") }
    }
  }
}
