package com.pokeboston.client
package scenes
package auth
package components
package registration
package forms

import steps._
import lib.passports._

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object EmailVerificationForm {
  case class Props(state: Map[String, String], onChange: ReactEventFromInput => Callback, onSubmit: ReactEvent => Callback)
  private val component = ScalaComponent.builder[Props]("EmailVerification")
    .render_P {
      case Props(state, onChange, onSubmit) =>
        <.form(
          ^.className := "animated slideInRight",
          ^.onSubmit ==> onSubmit)(
          <.div(^.className := "form-group")(
            <.div(^.className := "input-group")(
              <.div(^.className := "input-group-prepend")(
                <.i(^.className := "input-group-text mdi mdi-unlock")
              ),
              <.input(
                ^.name := "verification_code",
                ^.`type` := "password",
                ^.className := "form-control",
                ^.placeholder := "Verification code",
                ^.value := state.getOrElse("verification_code", ""),
                ^.onChange ==> onChange),
            )
          ),
          <.button(^.`type` := "submit", ^.className := "float-right btn btn-lg btn-primary btn-block")(
            <.i(^.className := "mdi mdi-account-plus"),
            " Verify"
          )
        )
    }.build
  def apply(state: Map[String, String], onChange: ReactEventFromInput => Callback, onSubmit: ReactEvent => Callback) =
    component(Props(state, onChange, onSubmit))
}
