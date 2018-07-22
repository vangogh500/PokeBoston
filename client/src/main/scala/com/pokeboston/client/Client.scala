package com.pokeboston.client

import org.scalajs.dom.document
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import stylings.AppStyling
import services.AppRouter

/**
 * Client App
 */
object Client extends App {
  AppStyling.init()
  AppRouter().renderIntoDOM(document.getElementById("app"))
}
