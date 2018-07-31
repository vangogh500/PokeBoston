package com.pokeboston.client
package scenes
package auth
package components
package registration
package strategies

import forms._
import steps._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

object EmailRegistrationStrategy {
  case class State(
    registrationState: Map[String, String],
    verificationState: Map[String, String])

  case class Props(step: RegistrationAppStep, onStepChange: RegistrationAppStep => Callback)

  class Backend($: BackendScope[Props, State]) {
    def onRegistrationChange(e: ReactEventFromInput) = {
      val value = e.target.value
      val target = e.target.name
      e.preventDefaultCB >> $.modState(s =>
        s.copy(registrationState = s.registrationState + (target -> value))
      )
    }
    def onRegistrationSubmit(onStepChange: RegistrationAppStep => Callback)(e: ReactEvent) = {
      e.preventDefaultCB >> onStepChange(VerificationStep)
    }
    def onVerificationChange(e: ReactEventFromInput) = {
      val value = e.target.value
      val target = e.target.name
      e.preventDefaultCB >> $.modState(s =>
        s.copy(verificationState = s.verificationState + (target -> value))
      )
    }
    def onVerificationSubmit(onStepChange: RegistrationAppStep => Callback)(e: ReactEvent) = {
      e.preventDefaultCB
    }

    def render(props: Props, state: State) = (props, state) match {
      case (Props(RegistrationStep, onStepChange), State(formState, _)) =>
        EmailRegistrationForm(formState, onRegistrationChange, onRegistrationSubmit(onStepChange))
      case (Props(VerificationStep, onStepChange), State(_, formState)) =>
        EmailVerificationForm(formState, onVerificationChange, onVerificationSubmit(onStepChange))
    }
  }

  private val component = ScalaComponent.builder[Props]("EmailRegistrationStrategy")
    .initialState(State(Map(), Map()))
    .renderBackend[Backend]
    .build

  def apply(step: RegistrationAppStep, onStepChange: RegistrationAppStep => Callback) =
    component(Props(step, onStepChange))
}
