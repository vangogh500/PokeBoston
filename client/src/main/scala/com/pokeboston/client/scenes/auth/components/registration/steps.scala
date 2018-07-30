package com.pokeboston.client
package scenes
package auth
package components
package registration

import stylings.{AppTypography}
import com.pokeboston.client.components.progress.HorizontalProgressWithBreadCrumbs.Step
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

package object steps {
  sealed trait RegistrationAppStep extends Step

  case object PassportStep extends RegistrationAppStep {
    def asBreadCrumb = <.i(^.className := "mdi mdi-passport", AppTypography.fSize(3))
  }
  case object RegistrationStep extends RegistrationAppStep {
    def asBreadCrumb = <.i(^.className := "mdi mdi-account-plus", AppTypography.fSize(3))
  }
  case object VerificationStep extends RegistrationAppStep {
    def asBreadCrumb = <.i(^.className := "mdi mdi-account-check", AppTypography.fSize(3))
  }
}
