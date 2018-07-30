package com.pokeboston.client
package scenes
package auth
package components

import login.LoginApp
import registration.RegistrationApp
import stylings.{AppTypography}
import com.pokeboston.client.components.progress._

import services.AppRouter.{AppPage, AuthPage}
import japgolly.scalajs.react.extra.router.{RouterCtl}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._


object AuthApp {
  case class Props(ctl: RouterCtl[AppPage], mode: String)
  case class State(loginApp: VdomElement, registrationApp: VdomElement)
  class Backend($: BackendScope[Props, State]) {
    def render(props: Props, state: State) = (props, state) match {
      case (Props(ctl, mode), State(loginApp, registrationApp)) =>
        <.div()(
          <.ul(^.className := "nav nav-tabs nav-fill")(
            <.li(^.className := "nav-item")(
              if(mode == "login") {
                <.a(^.className := "nav-link active")("Login")
              } else {
                ctl.link(AuthPage("login"))(^.className := "nav-link")("Login")
              }
            ),
            <.li(^.className := "nav-item")(
              if(mode == "register") {
                <.a(^.className := "nav-link active")("Register")
              } else {
                ctl.link(AuthPage("register"))(^.className := "nav-link")("Register")
              }
            )
          ),
          <.div(^.className := "card-body")(
            if(mode == "login") {
              loginApp
            } else if(mode == "register") {
              registrationApp
            } else {
              <.div()
            }
          )
        )
    }
  }
  private val component = ScalaComponent.builder[Props]("AuthForm")
    .initialState(State(LoginApp(), RegistrationApp()))
    .renderBackend[Backend]
    .build
  def apply(ctl: RouterCtl[AppPage], mode: String) = component(Props(ctl, mode))
}
