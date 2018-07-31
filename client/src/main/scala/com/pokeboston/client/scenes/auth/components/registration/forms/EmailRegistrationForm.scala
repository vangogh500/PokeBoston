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

object EmailRegistrationForm {
  case class Props(state: Map[String, String], onChange: ReactEventFromInput => Callback, onSubmit: ReactEvent => Callback)
  private val component = ScalaComponent.builder[Props]("EmailRegistrationForm")
    .render_P {
      case Props(state, onChange, onSubmit) =>
        <.form(
          ^.className := "animated slideInRight",
          ^.onSubmit ==> onSubmit)(
          <.div(^.className := "form-group")(
            <.div(^.className := "input-group")(
              <.div(^.className := "input-group-prepend")(
                <.i(^.className := "input-group-text mdi mdi-email")
              ),
              <.input(
                ^.name := "email",
                ^.`type` := "email",
                ^.className := "form-control",
                ^.placeholder := "Email",
                ^.value := state.getOrElse("email", ""),
                ^.onChange ==> onChange)
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
                ^.placeholder := "Password",
                ^.value := state.getOrElse("password", ""),
                ^.onChange ==> onChange),
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
                ^.placeholder := "Confirm password",
                ^.value := state.getOrElse("password_confirmation", ""),
                ^.onChange ==> onChange)
            )
          ),
          <.button(^.`type` := "submit", ^.className := "float-right btn btn-lg btn-primary btn-block")(
            <.i(^.className := "mdi mdi-account-plus"),
            " Register"
          )
        )
    }.build
  def apply(state: Map[String, String], onChange: ReactEventFromInput => Callback, onSubmit: ReactEvent => Callback) =
    component(Props(state, onChange, onSubmit))
}
