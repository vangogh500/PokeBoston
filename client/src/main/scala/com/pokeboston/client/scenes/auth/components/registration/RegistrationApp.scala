package com.pokeboston.client
package scenes
package auth
package components
package registration

import stylings.{AppTypography}
import lib.passports._
import com.pokeboston.client.components.progress.HorizontalProgressWithBreadCrumbs.ProgressStep
import steps._
import strategies._
import com.pokeboston.client.components.progress._

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._

import collection.immutable.ListMap


object RegistrationApp {
  case class State(step: RegistrationAppStep, passport: Option[AuthPassport])

  class Backend($: BackendScope[Unit, State]) {
    val steps = Seq(PassportStep, RegistrationStep, VerificationStep)
    val stepMap: ListMap[RegistrationAppStep, ProgressStep] = ListMap(
      steps.map { step =>
        (step -> step.asProgressStep(onStepSelect(step)))
      }: _*)
    def onStepSelect(target: RegistrationAppStep)(e: ReactEvent) = {
      e.preventDefaultCB >> $.modState(s => s match {
        case state @ State(curr, _) if(steps.indexOf(target) < steps.indexOf(curr)) =>
          state.copy(step = target)
        case state => state
      })
    }
    def onPassportSelect(passport: AuthPassport)(e: ReactEvent) = {
      e.preventDefaultCB >> $.setState(State(RegistrationStep, Some(passport)))
    }
    def onStepChange(target: RegistrationAppStep) = {
      $.modState(s => s.copy(step = target))
    }
    def renderProgress(step: RegistrationAppStep) = {
      HorizontalProgressWithBreadCrumbs(VdomStyle("marginBottom") := "40px")(stepMap(step), stepMap.values.toSeq)
    }
    def render(state: State) = state match {
      case State(PassportStep, _) =>
        <.div(^.className := "card-body", VdomStyle("overflowX") := "hidden")(
          renderProgress(PassportStep),
          PassportPicker(onPassportSelect)
        )
      case State(step, Some(passport)) =>
        <.div(^.className := "card-body", VdomStyle("overflowX") := "hidden")(
          renderProgress(step),
          EmailRegistrationStrategy(step, onStepChange)
        )
    }
  }
  private val component = ScalaComponent.builder[Unit]("RegistrationApp")
    .initialState(State(PassportStep, None))
    .renderBackend[Backend]
    .build

  def apply() = component()
}
