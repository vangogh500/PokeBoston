package com.pokeboston.client
package components
package progress

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.Attr
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

import com.pokeboston.client.stylings.{AppLayout, AppAnimations}
import stylings.{HorizontalProgressWithBreadCrumbStylings => Stylings, HorizontalProgressStylings}

/**
 * Horizontal progress with bread crumbs
 */
object HorizontalProgressWithBreadCrumbs {
  trait ProgressStep {
    def asBreadCrumb: VdomElement
    def onClick(e: ReactEvent) = e.preventDefaultCB
  }
  /**
   * Component props
   * @param progress A representation of progress by number of steps completed
   * @param steps A seq of dom labels for each step
   */
  case class Props(curr: ProgressStep, steps: Seq[ProgressStep], tags: TagMod*)
  private val component = ScalaComponent.builder[Props]("HorizontalProgressWithBreadCrumbs")
    .render_P {
      case Props(curr, steps, tags @ _*) if steps.contains(curr) =>
        val index = steps.indexOf(curr)
        val padding = 100 / Math.max(steps.length - 1, 1)
        val percentage = padding * index
        <.div(^.className := "w-100")(tags:_*)(
          <.div(^.className := "w-100 d-flex justify-content-center align-items-center position-relative")(
            HorizontalProgress(
              ^.className := "position-absolute",
              Stylings.Progress,
              HorizontalProgressStylings.animExpand100)(percentage),
            <.div(^.className := "w-100 d-flex justify-content-between", AppLayout.zindex(2))(
              steps.zipWithIndex.toTagMod {
                case (step, i) if i < index =>
                  ProgressBreadCrumb(
                    Stylings.PastStep,
                    AppAnimations.Teeter,
                    ^.onClick ==> step.onClick,
                    ^.className := "animated infinite slower")()
                case (step, i) if i == index =>
                  ProgressBreadCrumb(
                    Stylings.FutureStep,
                    AppAnimations.animDelay(i),
                    ^.onClick ==> step.onClick,
                    ^.className := "animated bounceIn")(
                      step.asBreadCrumb)
                case (step, i) if i > index =>
                  ProgressBreadCrumb(
                    Stylings.FutureStep,
                    AppAnimations.animDelay(i),
                    ^.onClick ==> step.onClick,
                    ^.className := "animated bounceIn")(
                      step.asBreadCrumb)
              }
            )
          )
        )
      case _ => throw new IndexOutOfBoundsException()
    }.build
  /**
   * Creates an instance of the component
   * @param progress A representation of progress by number of steps completed
   * @param steps A seq of dom labels for each step
   */
  def apply(tags: TagMod*)(curr: ProgressStep, steps: Seq[ProgressStep]) = component(Props(curr, steps, tags:_*))
  def apply(curr: ProgressStep, steps: Seq[ProgressStep]) = component(Props(curr, steps))
}
