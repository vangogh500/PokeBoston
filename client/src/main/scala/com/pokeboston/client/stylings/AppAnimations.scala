package com.pokeboston.client
package stylings

import scalacss.DevDefaults._

/**
 * Layout related stylings for app
 */
object AppAnimations extends StyleSheet.Inline {
  import dsl._

  val animDelay = styleF(Domain.ofRange(0 to 20))(n => styleS(
    animationDelay := (n / 4.0) + "s"
  ))

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

  private val kfExpandW_100 = keyframes(
    (0%%) -> style(
      width := "0",
      height := "0",
    ),
    (75%%) -> style(
      width := "0",
      height := "1rem"
    ),
    (100%%) -> style(
      width := "100%"
    )
  )

  val Teeter = style(
    animationName(kfTeeter),
    animationDuration := "5s"
  )
  val ExpandW_100 = style(
    animationName(kfExpandW_100),
    animationDuration := "2s"
  )
}
