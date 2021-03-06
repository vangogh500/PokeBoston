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
import v1.services.auth.responses._
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
      case Success(AuthServiceLoginResponse(idToken, accessToken, refreshToken, challenge)) => Success(
        Ok(JsObject(Seq(
            "challenge" -> challenge.asJsValue
          )))
          .withCookies(Cookie("IdToken", idToken, Some(3000), secure = true, httpOnly = true))
          .withCookies(Cookie("AccessToken", accessToken, Some(3000), secure = true, httpOnly = true))
      )
      case Failure(ClientSyntaxException(_)) => Success(BadRequest(""))
      case Failure(ClientAuthException(_)) => Success(Forbidden(""))
      case Failure(_) => Success(InternalServerError(""))
    }
  }
}
