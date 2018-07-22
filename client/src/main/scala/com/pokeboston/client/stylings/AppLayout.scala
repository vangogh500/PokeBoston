package com.pokeboston.client
package stylings

import scalacss.DevDefaults._

/**
 * Layout related stylings for app
 */
object AppLayout extends StyleSheet.Inline {
  import dsl._
  /**
   * Background center styling
   */
  val bgCenter = style(
    backgroundPosition := "center"
  )
  /**
   * Background size cover styling
   */
  val bgCover = style(
    backgroundSize := "cover"
  )
}
