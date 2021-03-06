package com.pokeboston.client
package components
package progress
package stylings

import scalacss.DevDefaults._

/**
 * Stylings for the ProgressBreadCrumb component
 */
object ProgressBreadCrumbStylings extends StyleSheet.Inline {
  import dsl._
  /**
   * Styligns for progress bread crumb container
   */
  val Container = style(
    width := "62px",
    height := "62px",
    borderRadius := "100%"
  )
}
