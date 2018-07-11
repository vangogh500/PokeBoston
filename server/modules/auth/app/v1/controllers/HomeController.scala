package v1
package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import sangria.marshalling.playJson._
import play.api.libs.json._
import sangria.execution._
import sangria.parser.{SyntaxError, QueryParser}
import javax.inject._
import play.api._
import play.api.mvc._
import scala.util.{Success, Failure}
import scala.concurrent.Future

import services.{AuthService, GQLServiceBuilder}
import models.AuthServiceResponse

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(gqlServiceBuilder: GQLServiceBuilder, authService: AuthService) extends InjectedController {

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
