package com.pokeboston.client
package components
package progress
package stylings

import services.api.AppStaticApi
import scalacss.DevDefaults._

/**
 * Stylings for the HorizontalProgressWithBreadCrumb component
 */
object HorizontalProgressWithBreadCrumbStylings extends StyleSheet.Inline {
  import dsl._
  /**
   * Progress stylings for HorizontalProgressWithBreadCrumb
   */
  val Progress = style(
    paddingLeft := "7px",
    paddingRight := "7px"
  )

  /**
   * Breadcrumb stylings for HorizontalProgressWithBreadCrumb that have yet to be completed
   */
  val FutureStep = style(
    backgroundColor := "#e9ecef"
  )

  /**
   * Progress stylings for HorizontalProgressWithBreadCrumb that have been completed
   */
  val PastStep = style(
    backgroundImage := s"""url("${AppStaticApi.getUrlForImg("pokeball.svg")}")""",
    backgroundSize := "75px 75px",
    backgroundPosition := "center"
  )
}
