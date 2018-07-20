package com.pokeboston.auth
package v1
package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.json._
import javax.inject._
import play.api._
import play.api.mvc._

import services.gqlauth.{GQLAuthService}
import v1.services.auth.{AuthService}

/**
 * GQL implementation of auth service
 */
@Singleton
class GQLController @Inject()(gqlService: GQLAuthService) extends InjectedController {
  /**
   * GQL endpoint
   */
  def index() = Action.async(parse.json) { request =>
    gqlService.execute(request.body).map { result =>
      Ok(result)
    }
  }
}
