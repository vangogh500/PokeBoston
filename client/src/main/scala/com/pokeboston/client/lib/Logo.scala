package com.pokeboston.client
package lib

object Logo {
  sealed trait AppLogo
  case class CssLogo(className: String) extends AppLogo
  case class UrlLogo(url: String) extends AppLogo
}
