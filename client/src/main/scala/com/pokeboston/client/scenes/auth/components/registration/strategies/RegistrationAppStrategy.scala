package com.pokeboston.client
package scenes
package auth
package components
package registration
package strategies

import stylings.{AppTypography}
import com.pokeboston.client.components.progress.HorizontalProgressWithBreadCrumbs.ProgressStep
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

trait RegistrationAppStrategy {
  val registrationForm: VdomElement
  val verificationForm: Option[VdomElement]
}

trait RegistrationAppStrategyBuilder {
  def build(
    registrationState: Map[String, String],
    verificationState: Map[String, String],
    onChange: ReactEventFromInput => Callback,
    onSubmit: ReactEvent => Callback): RegistrationAppStrategy
}
