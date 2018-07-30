package com.pokeboston.client
package components
package progress

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.Attr
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

import stylings.{ProgressBreadCrumbStylings => Stylings}

/**
 * Bread crumbs used in ProgressWithBreadCrumbs components
 */
object ProgressBreadCrumb {
  /**
   * Component props
   * @param tags Tags and stylings to apply to the bread crumb container
   */
  case class Props(tags: TagMod*)
  private val component = ScalaComponent.builder[Props]("ProgressBreadCrumb")
    .render_PC {
      case (Props(tags @ _*), children) =>
        <.div(^.className := "d-flex justify-content-center align-items-center",
          Stylings.Container)(tags:_*)(children)
    }.build
  /**
   * Creates an instance of the component
   * @param tags Tags and stylings to apply
   * @param children The content of the breadcrumb
   */
  def apply(tags: TagMod*)(children: CtorType.ChildArg*) = component(Props(tags:_*))(children:_*)
}
