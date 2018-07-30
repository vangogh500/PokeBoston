package com.pokeboston.client
package scenes
package auth
package components
package registration

import stylings.{AppTypography}
import lib.passports._
import steps._
import strategies._
import com.pokeboston.client.components.progress._

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._


object RegistrationApp {
  case class State(curr: RegistrationAppStep, passport: Option[AuthPassport])
  class Backend($: BackendScope[Unit, State]) {
    def onPassportSelect(passport: AuthPassport)(e: ReactEvent) = {
      e.preventDefaultCB >> $.modState(s => State(RegistrationStep, Some(passport)))
    }
    def onSubmit(e: ReactEvent)(step: RegistrationAppStep, content: Map[String, String]) = {
      e.preventDefaultCB
    }
    def render(state: State) = state match {
      case State(PassportStep, _) =>
        <.div(^.className := "card-body", VdomStyle("overflowX") := "hidden")(
          HorizontalProgressWithBreadCrumbs(PassportStep, Seq(
            PassportStep,
            RegistrationStep,
            VerificationStep
          )),
          PassportPicker(onPassportSelect)
        )
      case State(step, Some(EmailPassport)) =>
        <.div(^.className := "card-body", VdomStyle("overflowX") := "hidden")(
          HorizontalProgressWithBreadCrumbs(VdomStyle("marginBottom") := "40px")(step, Seq(
            PassportStep,
            RegistrationStep,
            VerificationStep
          )),
          EmailRegistrationStrategy(step, onSubmit)
        )
    }
  }
  private val component = ScalaComponent.builder[Unit]("RegistrationApp")
    .initialState(State(PassportStep, None))
    .renderBackend[Backend]
    .build
  def apply() = component()
}
