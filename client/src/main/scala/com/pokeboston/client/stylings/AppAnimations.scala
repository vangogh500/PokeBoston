package com.pokeboston.client
package stylings

import scalacss.DevDefaults._

/**
 * Layout related stylings for app
 */
object AppAnimations extends StyleSheet.Inline {
  import dsl._

  private val kfTeeter = keyframes(
    (0 %%) -> style(
      transform := "rotate(0deg)"
    ),
    (44 %%) -> style(
      transform := "rotate(-10deg)"
    ),
    (46 %%) -> style(
      transform := "rotate(0deg)"
    ),
    (48 %%) -> style(
      transform := "rotate(-10deg)"
    ),
    (50 %%) -> style(
      transform := "rotate(0deg)"
    ),
    (92 %%) -> style(
      transform := "rotate(0deg)"
    ),
    (94 %%) -> style(
      transform := "rotate(10deg)"
    ),
    (96 %%) -> style(
      transform := "rotate(0deg)"
    ),
    (98 %%) -> style(
      transform := "rotate(10deg)"
    ),
    (100 %%) -> style(
      transform := "rotate(0deg)"
    )
  )

  val Teeter = style(
    animationName(kfTeeter),
    animationDuration := "4s"
  )
}
