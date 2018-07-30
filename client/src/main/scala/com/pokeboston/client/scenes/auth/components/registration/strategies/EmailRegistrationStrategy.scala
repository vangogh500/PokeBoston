package com.pokeboston.client
package scenes
package auth
package components
package registration
package strategies

import steps._
import lib.passports._

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object EmailRegistrationStrategy {
  case class State(registrationState: Map[String, String], verificationState: Map[String, String])
  case class Props(step: RegistrationAppStep, onSubmit: ReactEvent => (RegistrationAppStep, Map[String,String]) => Callback)
  class Backend($: BackendScope[Props, State]) {
    def onRegistrationChange(e: ReactEventFromInput) = {
      println(e)
      val value = e.target.value
      val target = e.target.name
      $.modState {s =>
        println(e)
        s.copy(
          registrationState = s.registrationState + (target -> value)
        )
      }
    }
    def render(props: Props, state: State) = (props, state) match {
      case (Props(RegistrationStep, _), state) =>
        <.form(^.className := "animated slideInRight")(
          <.div(^.className := "form-group")(
            <.div(^.className := "input-group")(
              <.div(^.className := "input-group-prepend")(
                <.i(^.className := "input-group-text mdi mdi-email")
              ),
              <.input(
                ^.name := "email",
                ^.`type` := "email",
                ^.className := "form-control",
                ^.value := state.registrationState.getOrElse("email", ""),
                ^.onChange ==> onRegistrationChange)
            )
          ),
          <.div(^.className := "form-group")(
            <.div(^.className := "input-group")(
              <.div(^.className := "input-group-prepend")(
                <.i(^.className := "input-group-text mdi mdi-lock")
              ),
              <.input(
                ^.name := "password",
                ^.`type` := "password",
                ^.className := "form-control",
                ^.value := state.registrationState.getOrElse("password", ""),
                ^.onChange ==> onRegistrationChange)
            )
          ),
          <.div(^.className := "form-group")(
            <.div(^.className := "input-group")(
              <.div(^.className := "input-group-prepend")(
                <.i(^.className := "input-group-text mdi mdi-lock-plus")
              ),
              <.input(
                ^.name := "password_confirmation",
                ^.`type` := "password",
                ^.className := "form-control",
                ^.value := state.registrationState.getOrElse("password_confirmation", ""),
                ^.onChange ==> onRegistrationChange)
            )
          ),
          <.button(^.`type` := "submit", ^.className := "float-right btn btn-primary")("Register")
        )
      case (Props(VerificationStep, _), state) =>
        <.form(^.className := "animated slideInRight")(
          <.div(^.className := "form-group")(
            <.label("Verification Code"),
            <.input(^.`type` := "password", ^.className := "form-control")
          )
        )
    }
  }
  val component = ScalaComponent.builder[Props]("EmailRegistrationForm")
    .initialState(State(Map(), Map()))
    .renderBackend[Backend]
    .build
  def apply(step: RegistrationAppStep, onSubmit: ReactEvent => (RegistrationAppStep, Map[String,String]) => Callback) =
    component(Props(step, onSubmit))
}
