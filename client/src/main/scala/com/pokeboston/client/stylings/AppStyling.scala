package com.pokeboston.client
package stylings

import scalacss.DevDefaults._
import components.progress.ProgressStylings

/**
 * Entry point to all app stylings
 */
object AppStyling {
  /**
   * Initialize/load styles into document
   */
  def init(): Unit = {
    AppLayout.addToDocument()
    AppSizing.addToDocument()
    ProgressStylings.addToDocument()
  }
}
