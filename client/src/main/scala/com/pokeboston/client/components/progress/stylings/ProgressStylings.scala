package com.pokeboston.client
package components
package progress
package stylings

import scalacss.DevDefaults._

/**
 * Progress components stylings
 */
object ProgressStylings {
 def init(): Unit = {
   HorizontalProgressStylings.addToDocument()
   HorizontalProgressWithBreadCrumbStylings.addToDocument()
   ProgressBreadCrumbStylings.addToDocument()
 }
}
