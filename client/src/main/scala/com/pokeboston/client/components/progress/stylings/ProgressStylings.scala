package com.pokeboston.client
package components
package progress
package stylings

import scalacss.DevDefaults._

/**
 * Layout related stylings for app
 */
object ProgressStylings {
 def init(): Unit = {
   HorizontalProgressWithBreadCrumbStylings.addToDocument()
   ProgressBreadCrumbStylings.addToDocument()
 }
}
