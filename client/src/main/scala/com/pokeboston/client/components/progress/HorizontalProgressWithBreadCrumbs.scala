package com.pokeboston.client
package components
package progress

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.Attr
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

import com.pokeboston.client.stylings.{AppLayout, AppAnimations}
import stylings.{HorizontalProgressWithBreadCrumbStylings => Stylings}

object HorizontalProgressWithBreadCrumbs {
  case class Props(progress: Int, steps: Seq[CtorType.ChildArg])
  private val component = ScalaComponent.builder[Props]("HorizontalProgressWithBreadCrumbs")
    .render_P {
      case Props(progress, steps) if progress >= steps.length => throw new IndexOutOfBoundsException()
      case Props(progress, steps) =>
       val padding = 100 / Math.max(steps.length - 1, 1)
       val percentage = padding * progress
        <.div(^.className := "w-100")(
          <.div(^.className := "w-100 d-flex justify-content-center align-items-center position-relative")(
            HorizontalProgress(^.className := "position-absolute",
              Stylings.Progress, AppAnimations.ExpandW_100)(percentage),
            <.div(^.className := "w-100 d-flex justify-content-between", AppLayout.zindex(2))(
              steps.zipWithIndex.toTagMod {
                case (step, i) if i < progress =>
                  ProgressBreadCrumb(Stylings.PastStep, AppAnimations.Teeter, ^.className := "animated infinite slower")()
                case (step, i) if i == progress =>
                  ProgressBreadCrumb(Stylings.FutureStep, AppAnimations.animDelay(i), ^.className := "animated bounceIn")(step)
                case (step, i) if i > progress =>
                  ProgressBreadCrumb(Stylings.FutureStep, AppAnimations.animDelay(i), ^.className := "animated bounceIn")(step)
              }
            )
          )
        )
    }.build
  def apply(progress: Int, steps: Seq[CtorType.ChildArg]) = component(Props(progress, steps))
}
