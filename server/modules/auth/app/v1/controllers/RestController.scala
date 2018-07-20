package com.pokeboston.auth
package v1
package controllers

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
 * REST implementation of auth service
 */
@Singleton
class RestController @Inject()(authService: AuthService) extends InjectedController {
  /**
   * Login endpoint
   */
  def login() = Action.async(parse.json) { request =>
    authService.login(request.body) transform {
      case Success(LoginResponse(Some(accessToken), Some(refreshToken))) => Success(
        Ok("")
          .withCookies(Cookie("AccessToken", accessToken, Some(3000), secure = true, httpOnly = true))
      )
      case Failure(ClientSyntaxException(_)) => Success(BadRequest(""))
      case Failure(ClientAuthException(_)) => Success(Forbidden(""))
      case Failure(_) => Success(InternalServerError(""))
    }
  }
}
