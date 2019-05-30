package de.htwg.se.muehle.controller

import de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl.{Controller, ControllerStateStatus}
import de.htwg.se.muehle.model.gridComponent.gridBaseImpl.Grid
import de.htwg.se.muehle.model.playerComponent.Player
import org.scalatest.{Matchers, WordSpec}

abstract class ControllerStateStatusPlacedSpec extends WordSpec with Matchers with ControllerStateStatus{
  "A State" when { "new" should {
    val grid = Grid(init = true)
    val player1 = Player("Person 1", 'W')
    val player2 = Player("Person 2", 'B')
    val controller = new Controller(grid, player1, player2)
    "All stones placed" in {
      allStonesPlaced(controller) should be ("All Stones are already placed.\nTo move a stone use the 'move' command.")
    }
    "slot is filled" in {
      slotIsFilled(controller) should be ("This field is already blocked.\nSelect another field to place your stone.")
    }
    "stones are still available" in {
      stonesStillAvailable(controller) should be (Option)
    }
    "slot is filled" in {
      selectedFieldInvalid(controller) should be (Option)
    }
    "selected field not reachable" in {
      selectedFieldNotEmpty(controller) should be (Option)
    }
    "selected field not reachable" in {
      selectedFieldNotReachable(controller) should be (Option)
    }
  }}

}
