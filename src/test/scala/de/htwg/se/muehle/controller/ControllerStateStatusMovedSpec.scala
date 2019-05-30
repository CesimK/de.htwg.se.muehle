package de.htwg.se.muehle.controller

import de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl.{Controller, ControllerStateStatus}
import de.htwg.se.muehle.model.gridComponent.gridBaseImpl.Grid
import de.htwg.se.muehle.model.playerComponent.Player
import org.scalatest.{Matchers, WordSpec}

abstract class ControllerStateStatusMovedSpec extends WordSpec with Matchers with ControllerStateStatus{
  "A State" when { "new" should {
    val grid = Grid(init = true)
    val player1 = Player("Person 1", 'W')
    val player2 = Player("Person 2", 'B')
    val controller = new Controller(grid, player1, player2)
    "all Stones are Placed" in {
      allStonesPlaced(controller) should be (Option)
    }
    "slot is filled" in {
      slotIsFilled(controller) should be (Option)
    }
    "selected field not reachable" in {
      selectedFieldNotReachable(controller) should be ("Target Field is no neighbour of your selected field.")
    }
  }}

}
