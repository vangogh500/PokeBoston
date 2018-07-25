package com.pokeboston.client
package components
package progress

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.Attr
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

import stylings.{ProgressBreadCrumbStylings => Stylings}

object ProgressBreadCrumb {
  case class Props(tags: TagMod*)
  private val component = ScalaComponent.builder[Props]("ProgressBreadCrumb")
    .render_PC {
      case (Props(tags @ _*), children) =>
        <.div(^.className := "d-flex justify-content-center align-items-center",
          Stylings.Container)(tags:_*)(children)
    }.build
  def apply(tags: TagMod*)(children: CtorType.ChildArg*) = component(Props(tags:_*))(children:_*)
}
