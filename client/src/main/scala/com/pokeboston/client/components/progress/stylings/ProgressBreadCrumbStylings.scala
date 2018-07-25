package com.pokeboston.client
package components
package progress
package stylings

import scalacss.DevDefaults._

/**
 * Layout related stylings for app
 */
object ProgressBreadCrumbStylings extends StyleSheet.Inline {
  import dsl._
  /**
   * Progress bread crumb
   */
  val Container = style(
    width := "62px",
    height := "62px",
    borderRadius := "100%"
  )
}
