package com.pokeboston.client
package stylings

import scalacss.DevDefaults._
import components.progress.stylings.ProgressStylings

/**
 * Entry point to all app stylings
 */
object AppStylings {
  /**
   * Initialize/load styles into document
   */
  def init(): Unit = {
    AppAnimations.addToDocument()
    AppColoring.addToDocument()
    AppLayout.addToDocument()
    AppSizing.addToDocument()
    AppTypography.addToDocument()
    ProgressStylings.init()
  }
}
