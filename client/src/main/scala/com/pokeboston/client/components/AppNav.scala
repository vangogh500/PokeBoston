package com.pokeboston.client
package components

import modal.ModalButton
import services.AppRouter.{AppPage, AuthPage}

import japgolly.scalajs.react.extra.router.{RouterCtl}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

object AppNav {
  private val component = ScalaComponent.builder[RouterCtl[AppPage]]("AppNav")
    .render_P(ctl =>
      <.nav(^.className := "navbar navbar-light navbar-expand-sm")(
        <.div(^.className := "container")(
          <.a(^.className := "navbar-brand")(
            <.img(^.src := "https://fontmeme.com/permalink/180722/3fab27004af3568242bac9c333f8ffce.png", ^.height := "50px")
          ),
          <.ul(^.className := "navbar-nav ml-auto")(
            <.li(^.className := "nav-item")(
              ctl.link(AuthPage("login"))(^.className := "nav-link")("Login")
            ),
            <.li(^.className := "nav-item")(
              <.a(^.className := "nav-link", "Signup")
            )
          )
        )
      )
    ).build
  def apply(ctl: RouterCtl[AppPage]) = component(ctl)
}
