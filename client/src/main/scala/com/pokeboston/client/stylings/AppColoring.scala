package com.pokeboston.client
package stylings

import scalacss.DevDefaults._
import japgolly.univeq._

/**
 * Size related stylings for app
 */
object AppColoring extends StyleSheet.Inline {
  import dsl._

  sealed trait AppColor {
    val asHexString: String
    def asScalaCssColor = Color(asHexString)
  }
  object AppColor {
    implicit def equality: UnivEq[AppColor] = UnivEq.derive
  }
  case object FacebookBlue extends AppColor {
    val asHexString = "#3B5998"
  }
  case object Cinnabar extends AppColor {
    val asHexString = "#DD4B39"
  }
  case object DeepSkyBlue extends AppColor {
    val asHexString = "#1dcaff"
  }
  case object TangerineYellow extends AppColor {
    val asHexString = "#ffcc03"
  }
  case object Mariner extends AppColor {
    val asHexString = "#2a75bb"
  }
  private val domain = Domain.ofValues[AppColor](FacebookBlue, Cinnabar, DeepSkyBlue, TangerineYellow, Mariner)
  val bgColor = styleF(domain){ c =>
    styleS(
      backgroundColor := c.asScalaCssColor
    )
  }
  val bdColor = styleF(domain){ c =>
    styleS(
      borderColor := c.asScalaCssColor
    )
  }
}
