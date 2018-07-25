package com.pokeboston.client
package components
package progress
package stylings

import services.api.AppStaticApi
import scalacss.DevDefaults._

/**
 * Layout related stylings for app
 */
object HorizontalProgressWithBreadCrumbStylings extends StyleSheet.Inline {
  import dsl._

  val Progress = style(
    paddingLeft := "2px",
    paddingRight := "2px"
  )

  val FutureStep = style(
    backgroundColor := "#e9ecef"
  )

  val PastStep = style(
    backgroundImage := s"""url("${AppStaticApi.getUrlForImg("pokeball.svg")}")""",
    backgroundSize := "75px 75px",
    backgroundPosition := "center"
  )
}
