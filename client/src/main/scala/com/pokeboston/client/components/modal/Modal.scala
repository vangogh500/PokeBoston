package com.pokeboston.client
package components
package modal

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

object Modal {
  sealed case class Props(onClick: ReactEvent => Callback)
  sealed class Backend($: BackendScope[Props, Unit]) {
    def render(props: Props, propsChildren: PropsChildren) = props match {
      case Props(onClick) =>
        <.div(
          ^.className := "position-fixed w-100 h-100 d-flex",
          VdomStyle("z-index") := "1",
          VdomStyle("top") := "0",
          VdomStyle("left") := "0",
          VdomStyle("background") := """rgba(0,0,0,0.5)""",
          ^.onClick ==> { e => props.onClick(e) })
    }
  }
  private val component = ScalaComponent.builder[Props]("Modal")
    .renderBackendWithChildren[Backend]
    .build

  def apply(onClick: ReactEvent => Callback)(children: CtorType.ChildArg*) = component(Props(onClick))(children: _*)
}
