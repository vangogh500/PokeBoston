package com.pokeboston.client
package components
package modal

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

object ModalButton {
  sealed case class Props(label: String, aTags: Seq[TagMod])
  sealed case class State(showModal: Boolean = false)
  sealed class Backend($: BackendScope[Props, State]) {
    def toggleModal() = {
      $.modState(s => s.copy(showModal = !s.showModal))
    }
    def onClick(e: ReactEvent) = {
      e.preventDefaultCB >> toggleModal()
    }
    def render(state: State, props: Props, propsChildren: PropsChildren) = props match {
      case Props(label, aTags) => state match {
        case State(true) =>
          <.div()(
            <.a(aTags:_*)(^.onClick ==> onClick)(label),
            Modal(onClick)()
          )
        case State(false) =>
          <.div()(
            <.a(aTags:_*)(^.onClick ==> onClick)(label)
          )
      }
    }
  }
  private val component = ScalaComponent.builder[Props]("ModalButton")
    .initialState(State())
    .renderBackendWithChildren[Backend]
    .build
  def apply(label: String, aTags: Seq[TagMod] = Seq())(children: CtorType.ChildArg*) = component(Props(label, aTags))(children: _*)
}
