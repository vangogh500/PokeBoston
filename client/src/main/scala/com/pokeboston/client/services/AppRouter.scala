package com.pokeboston.client
package services

import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router._

import scenes.home.HomeScene


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
   * React component
   */
  private val component = Router(BaseUrl.fromWindowOrigin_/, RouterConfigDsl[AppPage].buildConfig { dsl =>
    import dsl._
    (emptyRule
    |   staticRoute(root, HomePage) ~> render(HomeScene())
    ).notFound(redirectToPage(HomePage)(Redirect.Push))
  })

  /**
   * Returns instance of react component
   */
  def apply() = component()
}
