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
        HorizontalProgressWithBreadCrumbs(1, Seq("1", "2", "3"))
      )
    )
  )
  def apply() = component()
}
