package com.pokeboston.client

import org.scalajs.dom.document
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import stylings.AppStylings
import services.AppRouter

/**
 * Client App
 */
object Client extends App {
  AppStylings.init()
  AppRouter().renderIntoDOM(document.getElementById("app"))
}
