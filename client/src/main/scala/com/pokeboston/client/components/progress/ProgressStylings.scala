package com.pokeboston.client
package components
package progress

import scalacss.DevDefaults._

/**
 * Layout related stylings for app
 */
object ProgressStylings extends StyleSheet.Inline {
  import dsl._
  /**
   * Background center styling
   */
  val ProgressVertical = style(
    display := "flex",
    height := "100%",
    position := "absolute",
    width := "1rem",
    overflow := "hidden",
    fontSize := ".75rem",
    backgroundColor := "#e9ecef",
    borderRadius := ".25rem"
  )

  val ProgressBarVertical = style(
    display := "flex",
    position := "absolute",
    width := "1rem",
    flexDirection := "row",
    justifyContent := "center",
    color := "#fff",
    textAlign := "center",
    whiteSpace := "nowrap",
    backgroundColor := "#007bff",
    transition := "height .6s ease"
  )
}
