package com.pokeboston.client
package services

import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router._

import scenes.home.HomeScene
import scenes.auth.AuthScene
import scenes.login.forms._


object AppRouter {
  /**
   * App page
   */
  sealed trait AppPage
  /**
   * Home page
   */
  case object HomePage extends AppPage
  /**
   * Auth page
   */
  case class AuthPage(mode: String) extends AppPage

  /**
   * React component
   */
  private val component = Router(BaseUrl.fromWindowOrigin_/, RouterConfigDsl[AppPage].buildConfig { dsl =>
    import dsl._
    (emptyRule
    |   staticRoute(root, HomePage) ~> renderR(ctl => HomeScene(ctl))
    |   dynamicRouteCT(("auth" / string("\\w+")).caseClass[AuthPage]) ~> dynRenderR {
          case (AuthPage(mode), ctl) => AuthScene(ctl, mode)
        }
    ).notFound(redirectToPage(HomePage)(Redirect.Push))
  })

  /**
   * Returns instance of react component
   */
  def apply() = component()
}
