package de.htwg.se.muehle.controller

import de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl.{ControllerStateStatus}
import org.scalatest.{Matchers, WordSpec}

abstract class ControllerStateStatusMovedSpec extends WordSpec with Matchers with ControllerStateStatus{
  "A State" when { "new" should {
    val status:String = ""
    "all Stones are Placed" in {
      allStonesPlaced(status) should be (Option)
    }
    "slot is filled" in {
      slotIsFilled(status) should be (Option)
    }
    "selected field not reachable" in {
      selectedFieldNotReachable should be ("Target Field is no neighbour of your selected field.")
    }
  }}

}
