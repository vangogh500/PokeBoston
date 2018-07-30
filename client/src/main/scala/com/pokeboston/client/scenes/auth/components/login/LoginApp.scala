package com.pokeboston.client
package scenes
package auth
package components
package login

import stylings.{AppTypography}
import lib.passports._
import com.pokeboston.client.components.progress._

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

object LoginApp {
  case object PassportStep extends HorizontalProgressWithBreadCrumbs.Step {
    def asBreadCrumb = <.i(^.className := "mdi mdi-passport", AppTypography.fSize(3))
  }
  case object LoginStep extends HorizontalProgressWithBreadCrumbs.Step {
    def asBreadCrumb = <.i(^.className := "mdi mdi-lock-open", AppTypography.fSize(3))
  }
  case class State(progress: Int)
  class Backend($: BackendScope[Unit, State]) {
    def onPassportSelect(passport: AuthPassport)(e: ReactEvent) = {
      e.preventDefaultCB
    }
    def render(state: State) = state match {
      case State(progress: Int) =>
        <.div(^.className := "card-body", VdomStyle("overflowX") := "hidden")(
          HorizontalProgressWithBreadCrumbs(VdomStyle("marginBottom") := "40px")(PassportStep, Seq(
            PassportStep,
            LoginStep
          )),
          PassportPicker(onPassportSelect)
        )
    }
  }
  private val component = ScalaComponent.builder[Unit]("RegistrationApp")
    .initialState(State(0))
    .renderBackend[Backend]
    .build
  def apply() = component()
}
