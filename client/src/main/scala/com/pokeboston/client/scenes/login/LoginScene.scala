package com.pokeboston.client
package scenes
package login

import stylings.AppLayout
import components.AppNav
import components.progress._

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

object LoginScene {
  case class State(progress: Int = 0)
  private val component = ScalaComponent.static("LoginScene")(
    <.div(^.className := "w-100 h-100 d-flex flex-column")(
      <.div(^.className := "container")(
        HorizontalProgressWithBreadCrumbs(0, Seq("1", "2", "3")),
        <.div(^.className := "")(
          <.button(^.`type` := "button", ^.className := "btn btn-primary btn-lg btn-block")(
            <.i(^.className := "mdi mdi-facebook-box")
          ),
          <.button(^.`type` := "button", ^.className := "btn btn-primary btn-lg btn-block")(
            <.i(^.className := "mdi mdi-google-plus-box")
          ),
          <.button(^.`type` := "button", ^.className := "btn btn-primary btn-lg btn-block")(
            <.i(^.className := "mdi mdi-twitter-box")
          )
        ),
        <.div(^.className := "dropdown-divider")("Or"),
        <.div(^.className := "")(
          <.button(^.`type` := "button", ^.className := "btn btn-primary btn-lg btn-block")(
            <.i(^.className := "mdi mdi-email")
          ),
          <.button(^.`type` := "button", ^.className := "btn btn-primary btn-lg btn-block")(
            <.i(^.className := "mdi mdi-cellphone-android")
          )
        ),
      )
    )
  )
  def apply() = component()
}
