package com.pokeboston.auth
package v1
package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.json._
import javax.inject._
import play.api._
import play.api.mvc._

import services.gqlauth.{GQLAuthServiceBuilder}
import v1.services.gqlauth.services.auth.{AuthService}

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(gqlServiceBuilder: GQLAuthServiceBuilder, authService: AuthService) extends InjectedController {

  private val gqlService = gqlServiceBuilder.build(authService)
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action.async(parse.json) { request =>
    gqlService.execute(request.body).map(Ok(_))
  }
}
