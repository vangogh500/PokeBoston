package com.pokeboston.client

import org.scalajs.dom.document
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

/**
 * Client App
 */
object Client extends App {
  val PlaceHolder = ScalaComponent.static("PlaceHolder")(<.h1("PokeBoston"))
  PlaceHolder().renderIntoDOM(document.getElementById("app"))
}
