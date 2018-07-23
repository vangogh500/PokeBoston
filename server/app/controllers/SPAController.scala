package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.json._
import javax.inject._
import play.api._
import play.api.mvc._


/**
 * SPA controller
 */
@Singleton
class SPAController @Inject()(env: Environment) extends InjectedController {

  def index() = at("")
  /**
   * GQL endpoint
   */
  def at(path: String) = {
    Assets.at("/public", "index.html")
  }
}
