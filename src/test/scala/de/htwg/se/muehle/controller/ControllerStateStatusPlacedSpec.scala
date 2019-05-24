package de.htwg.se.muehle.controller

import de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl.ControllerStateStatus
import org.scalatest.{Matchers, WordSpec}

abstract class ControllerStateStatusPlacedSpec extends WordSpec with Matchers with ControllerStateStatus{
  "A State" when { "new" should {
    val status:String = ""
    "All stones placed" in {
      allStonesPlaced(status) should be ("All Stones are already placed.\nTo move a stone use the 'move' command.")
    }
    "slot is filled" in {
      slotIsFilled(status) should be ("This field is already blocked.\nSelect another field to place your stone.")
    }
    "stones are still available" in {
      stonesStillAvailable(status) should be (Option)
    }
    "slot is filled" in {
      selectedFieldInvalid(status) should be (Option)
    }
    "selected field not reachable" in {
      selectedFieldNotEmpty(status) should be (Option)
    }
    "selected field not reachable" in {
      selectedFieldNotReachable should be (Option)
    }
  }}

}
