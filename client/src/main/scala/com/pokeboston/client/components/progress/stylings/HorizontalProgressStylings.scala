package com.pokeboston.client
package components
package progress
package stylings

import services.api.AppStaticApi
import scalacss.DevDefaults._

/**
 * Stylings for the HorizontalProgress component
 */
object HorizontalProgressStylings extends StyleSheet.Inline {
  import dsl._

  private val kfanimExpand100 = keyframes(
    (0%%) -> style(
      width := "0",
      height := "0",
    ),
    (74%%) -> style(
      width := "0",
      height := "0"
    ),
    (75%%) -> style(
      width := "0",
      height := "1rem"
    ),
    (100%%) -> style(
      width := "100%"
    )
  )
  /**
   * Animation that expands progress from 0 to 100
   */
  val animExpand100 = style(
    animationName(kfanimExpand100),
    animationDuration := "2s"
  )
}
