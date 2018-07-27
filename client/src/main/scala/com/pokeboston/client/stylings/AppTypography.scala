package com.pokeboston.client
package stylings

import scalacss.DevDefaults._

/**
 * Size related stylings for app
 */
object AppTypography extends StyleSheet.Inline {
  import dsl._
  /**
   * Width by view width
   * @param n % of view width
   */
  val fSize = styleF(Domain.ofRange(1 to 10))(n => styleS(
    fontSize := (n/2) + "em"
  ))
  /**
   * Height by view height
   * @param n % of view height
   */
  val h_vh = styleF(Domain.ofRange(25 to 100 by 25))(n => styleS(
    height := n + "vh"
  ))

  /**
   * Background size cover styling
   */
  val bgCover = style(
    backgroundSize := "cover"
  )
}
