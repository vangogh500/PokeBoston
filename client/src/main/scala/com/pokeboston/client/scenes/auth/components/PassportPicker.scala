package com.pokeboston.client
package scenes
package auth
package components

import stylings.{AppTypography}
import lib.passports._
import com.pokeboston.client.lib.Logo.{CssLogo, UrlLogo}

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._


object PassportPicker {
  case class Props(onClick: AuthPassport => ReactEvent => Callback)
  class Backend($: BackendScope[Props, Unit]) {
    def buildButton(onClick: AuthPassport => ReactEvent => Callback)(passport: AuthPassport) = {
      <.button(
        ^.key := passport.toString,
        ^.`type` := "button",
        ^.className := "btn btn-block shadow-sm btn-light",
        ^.onClick ==> onClick(passport))(
        passport.logo match {
          case UrlLogo(url) =>
            <.img(
              VdomStyle("height") := "32px",
              VdomStyle("width") := "32px",
              ^.src := url)
          case CssLogo(css) =>
            <.i(^.className := "mdi " + css, AppTypography.fSize(5))
        }
      )
    }
    def render(props: Props) = props match {
      case Props(onClick) =>
        <.div(^.className := "animated slideInRight")(
          <.h4(^.className := "text-center")("Choose a passport"),
          <.hr(),
          appPassports.toVdomArray { p => buildButton(onClick)(p) },
          <.hr(),
          socialMediaPassports.toVdomArray { p => buildButton(onClick)(p) }
        )
    }
  }
  private val component = ScalaComponent.builder[Props]("PassportPicker")
    .renderBackend[Backend]
    .build
  def apply(onClick: AuthPassport => ReactEvent => Callback) = component(Props(onClick))
}
