package v1
package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future}
import javax.inject._
import play.api._
import play.api.mvc._
import scala.util.{Success, Failure}

import services.AuthService
import models.AuthServiceResponse

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(authService: AuthService) extends InjectedController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action.async { implicit request: Request[AnyContent] =>
    authService.login("vangogh@gmail.com", "112345WAD%") transform {
      case Success(res) => Success(Ok(res.toString))
      case Failure(e) => Success(Ok(e.toString))
    }
  }
}
