package com.pokeboston.client
package scenes
package auth

import components.AuthApp

import services.AppRouter.{AppPage}
import japgolly.scalajs.react.extra.router.{RouterCtl}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

object AuthScene {
  case class Props(ctl: RouterCtl[AppPage], mode: String)
  private val component = ScalaComponent.builder[Props]("LoginScene")
    .render_P {
      case Props(ctl, mode) =>
        <.div(^.className := "w-100 h-100 d-flex justify-content-center align-items-center", VdomStyle("background") := "#fafafa")(
          <.div(^.className := "col-sm-12 col-md-8 col-lg-4")(
            <.div(^.className := "card shadow")(
              AuthApp(ctl, mode)
            )
          )
        )
    }.build
  def apply(ctl: RouterCtl[AppPage], mode: String) = component(Props(ctl, mode))
}
