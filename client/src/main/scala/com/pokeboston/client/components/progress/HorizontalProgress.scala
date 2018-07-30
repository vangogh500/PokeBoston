package com.pokeboston.client
package components
package progress

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.Attr
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

/**
 * Horizontal progress bar component
 * @see https://getbootstrap.com/docs/4.1/components/progress/
 */
object HorizontalProgress {
  /**
   * Component props
   * @param progress A representation of the progress from 0 to 100
   * @param tags Tags and stylings to give the progress
   */
  case class Props(progress: Int, tags: TagMod*)
  private val component = ScalaComponent.builder[Props]("HorizontalProgress")
    .render_P {
      case Props(progress, tags @ _*) =>
        <.div(^.className := "progress w-100")(tags:_*)(
          <.div(
            ^.className := "progress-bar",
            VdomStyle("width") := progress + "%",
            ^.role := "progressbar",
            Attr("aria-valuenow") := progress,
            Attr("aria-valuemin") := "0",
            Attr("aria-valuemax") := "100")
        )
    }.build
  /**
   * Creates an instance of the component
   * @param tags Tags and stylings to apply
   * @param progress A representation of the progress from 0 to 100
   */
  def apply(tags: TagMod*)(progress: Int) = component(Props(progress, tags:_*))
}
