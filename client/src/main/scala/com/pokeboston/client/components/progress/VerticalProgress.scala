package com.pokeboston.client
package components
package progress

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.Attr
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

object VerticalProgress {
  private val component = ScalaComponent.static("VerticalProgress")(
    <.div(ProgressStylings.ProgressVertical)(
      <.div(
        ProgressStylings.ProgressBarVertical,
        VdomStyle("height") := "75%",
        ^.role := "progressbar",
        Attr("aria-valuenow") := "75",
        Attr("aria-valuemin") := "0",
        Attr("aria-valuemax") := "100")
    )
  )

  def apply() = component()
}
