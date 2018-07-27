package com.pokeboston.client
package scenes
package login

import stylings.{AppLayout, AppTypography, AppColoring}
import components.AppNav
import components.progress._
import services.api.AppStaticApi

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

object LoginScene {
  case class State(progress: Int = 0)
  private val component = ScalaComponent.static("LoginScene")(
    <.div(^.className := "w-100 h-100 d-flex flex-column", VdomStyle("background") := "#fafafa")(
      <.div(^.className := "d-flex justify-content-center", VdomStyle("margin") := "50px 0px")(
        <.img(^.src := "https://fontmeme.com/permalink/180722/3fab27004af3568242bac9c333f8ffce.png", ^.height := "50px")
      ),
      <.div(^.className := "container")(
        HorizontalProgressWithBreadCrumbs(0, Seq("1", "2", "3")),
        <.div(^.className := "d-flex flex-wrap justify-content-around")(
          Seq(
            "https://upload.wikimedia.org/wikipedia/commons/f/ff/Facebook_logo_36x36.svg",
            "https://upload.wikimedia.org/wikipedia/fr/c/c8/Twitter_Bird.svg",
            "https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg",
            "https://upload.wikimedia.org/wikipedia/commons/5/5f/Windows_logo_-_2012.svg"
          ).toVdomArray { imgUrl =>
            <.div(^.className := "col-sm-3 d-flex justify-content-center")(
              <.div(
                ^.className := "card shadow",
                VdomStyle("width") := "80%",
                VdomStyle("height") := "100px",
                VdomStyle("border") := "none")(
                <.div(^.className := "card-body d-flex justify-content-center align-items-center")(
                  <.img(
                    VdomStyle("height") := "64px",
                    VdomStyle("width") := "64px",
                    ^.src := imgUrl)
                )))
          }
        ),
        <.div(^.className := "d-flex justify-content-center align-items-center position-relative", VdomStyle("margin") := "30px 0px")(
          <.hr(^.className := "position-absolute w-100", VdomStyle("margin") := "0"),
          <.div(VdomStyle("background") := "#fafafa", AppLayout.zindex(10))(
            <.h4(^.className := "display-4")("OR")
          )
        ),
        <.div(^.className := "d-flex flex-wrap justify-content-around")(
          Seq(
            "mdi-email",
            "mdi-cellphone-android"
          ).toVdomArray { logo =>
            <.div(^.className := "col-sm-3 d-flex justify-content-center")(
              <.div(
                ^.className := "card shadow",
                VdomStyle("width") := "80%",
                VdomStyle("height") := "100px",
                VdomStyle("border") := "none")(
                <.div(^.className := "card-body d-flex justify-content-center align-items-center")(
                  <.i(^.className := "mdi " + logo, AppTypography.fSize(7))
                )))
          }
        )
      )
    )
  )
  def apply() = component()
}
