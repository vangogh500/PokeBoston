package com.pokeboston.client
package services

import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router._

import scenes.home.HomeScene
import scenes.login.LoginScene


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
   * Login page
   */
  case object LoginPage extends AppPage

  /**
   * React component
   */
  private val component = Router(BaseUrl.fromWindowOrigin_/, RouterConfigDsl[AppPage].buildConfig { dsl =>
    import dsl._
    (emptyRule
    |   staticRoute(root, HomePage) ~> renderR(ctl => HomeScene(ctl))
    |   staticRoute("auth/login", LoginPage) ~> render(LoginScene())
    ).notFound(redirectToPage(HomePage)(Redirect.Push))
  })

  /**
   * Returns instance of react component
   */
  def apply() = component()
}
