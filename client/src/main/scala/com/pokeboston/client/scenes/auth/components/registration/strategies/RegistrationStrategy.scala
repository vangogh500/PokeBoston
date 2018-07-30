package com.pokeboston.client
package scenes
package auth
package components
package registration
package strategies

import steps._
import lib.passports._

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

sealed abstract class RegistrationStrategy[T <: AuthPassport](onSubmit: ReactEvent => Map[String,String] => Callback) {
  def registrationForm: VdomElement
  def verificationForm: Option[VdomElement]
  private val cache = Map[RegistrationAppStep, Option[VdomElement]](
    RegistrationStep -> Some(registrationForm),
    VerificationStep -> verificationForm
  )
  def apply(step: RegistrationAppStep) = cache(step)
}
