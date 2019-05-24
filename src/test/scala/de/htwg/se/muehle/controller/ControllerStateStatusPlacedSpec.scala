package de.htwg.se.muehle.controller

import de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl.ControllerStateStatus
import org.scalatest.{Matchers, WordSpec}

abstract class ControllerStateStatusPlacedSpec extends WordSpec with Matchers with ControllerStateStatus{
  "A State" when { "new" should {
    val status:String = ""
    "all Stones are Placed" in {
      stonesStillAvailable(status) should be (Option)
    }
    "slot is filled" in {
      selectedFieldInvalid(status) should be (Option)
    }
    "selected field not reachable" in {
      selectedFieldNotEmpty(status) should be (Option)
    }
  }}

}
