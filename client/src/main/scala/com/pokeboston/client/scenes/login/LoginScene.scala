package com.pokeboston.client
package scenes
package login

import components.AppNav
import components.progress.VerticalProgress
import stylings.AppLayout

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

object LoginScene {
  private val component = ScalaComponent.static("LoginScene")(
    <.div(^.className := "w-100 h-100 d-flex flex-column")(
      <.div(^.className := "d-flex flex-grow-1 justify-content-center align-items-center")(
        VerticalProgress()
      )
    )
  )
  def apply() = component()
}
