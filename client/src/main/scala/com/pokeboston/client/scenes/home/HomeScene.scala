package com.pokeboston.client
package scenes
package home

import components.AppNav
import stylings.{AppLayout, AppSizing}
import services.AppRouter.AppPage

import japgolly.scalajs.react.extra.router.{RouterCtl}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

object HomeScene {
  private val bgImage = "https://res.cloudinary.com/simpleview/image/upload/c_fill,f_auto,h_878,q_75,w_1903/v1/clients/boston/BostonAerails_KyleKlein_KKP12001_5c3e779e-3e93-4634-839c-b1ac087f7ece.jpg"
  private val component = ScalaComponent.builder[RouterCtl[AppPage]]("HomeScene")
    .render_P(ctl =>
      <.div(^.className := "w-100 h-100 d-flex flex-column")(
        AppNav(ctl),
        <.div(^.className := "d-flex flex-grow-1 justify-content-center align-items-center",
          VdomStyle("backgroundImage") := s"""url("$bgImage")""",
          VdomStyle("filter") := "grayscale(50%)",
          AppLayout.bgCenter,
          AppSizing.bgCover)
      )
    ).build
  def apply(ctl: RouterCtl[AppPage]) = component(ctl)
}
