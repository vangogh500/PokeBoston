package com.pokeboston.client

import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.dom.raw.HTMLElement
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import stylings.AppStylings
import services.AppRouter

/**
 * Client App
 */
object Client extends App {
  AppStylings.init()

  private def resize() = {
    document.getElementById("app").asInstanceOf[HTMLElement].style.height = document.documentElement.scrollHeight + "px"
    document.getElementById("app").asInstanceOf[HTMLElement].style.width = document.documentElement.clientWidth + "px"
  }
  resize()
  dom.window.onresize = { ev =>
    resize()
  }
  AppRouter().renderIntoDOM(document.getElementById("app"))
}
