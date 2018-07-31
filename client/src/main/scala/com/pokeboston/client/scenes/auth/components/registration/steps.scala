package com.pokeboston.client
package scenes
package auth
package components
package registration

import stylings.{AppTypography}
import com.pokeboston.client.components.progress.HorizontalProgressWithBreadCrumbs.ProgressStep
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

package object steps {
  sealed trait RegistrationAppStep {
    def asProgressStep(handleClick: ReactEvent => Callback = e => e.preventDefaultCB): ProgressStep
  }
  case object PassportStep extends RegistrationAppStep {
    def asProgressStep(handleClick: ReactEvent => Callback = e => e.preventDefaultCB) = new ProgressStep {
      def asBreadCrumb = <.i(^.className := "mdi mdi-passport", AppTypography.fSize(3))
      override def onClick(e: ReactEvent) = handleClick(e)
    }
  }
  case object RegistrationStep extends RegistrationAppStep {
    def asProgressStep(handleClick: ReactEvent => Callback = e => e.preventDefaultCB) = new ProgressStep {
      def asBreadCrumb = <.i(^.className := "mdi mdi-account-plus", AppTypography.fSize(3))
      override def onClick(e: ReactEvent) = handleClick(e)
    }
  }
  case object VerificationStep extends RegistrationAppStep {
    def asProgressStep(handleClick: ReactEvent => Callback = e => e.preventDefaultCB) = new ProgressStep {
      def asBreadCrumb = <.i(^.className := "mdi mdi-account-check", AppTypography.fSize(3))
      override def onClick(e: ReactEvent) = handleClick(e)
    }
  }
}
