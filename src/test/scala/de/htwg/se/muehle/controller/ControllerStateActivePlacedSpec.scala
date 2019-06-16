package de.htwg.se.muehle.controller

import de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl._
import de.htwg.se.muehle.model.gridComponent.gridBaseImpl.Grid
import de.htwg.se.muehle.model.playerComponent.Player
import org.scalatest.{Matchers, WordSpec}

class ControllerStateActivePlacedSpec extends WordSpec with Matchers{
  "A State" when { "new" should {
    val active_moved = new ControllerStateActivePlaced
    val grid = Grid(init = true)
    val player1 = Player("Person 1", 'W')
    val player2 = Player("Person 2", 'B')
    val controller = new Controller(grid, player1, player2)
    "should switch active player after placed" in {
      if (controller.active.name.equals(controller.p1.name)) {
        active_moved.switchActivePlayerPlaced(controller) should be(controller.active = controller.p2)
      } else {
        active_moved.switchActivePlayerPlaced(controller) should be(controller.active = controller.p1)
      }
    }
    "should switch active player after removed" in {
      if (controller.active.name.equals(controller.p1.name)) {
        active_moved.switchActivePlayerRemoved(controller) should be(controller.active = controller.p2)
      } else {
        active_moved.switchActivePlayerRemoved(controller) should be(controller.active = controller.p1)
      }
    }
    "should switch active player after moved" in {
      active_moved.switchActivePlayerMoved(controller) should be (controller.active = null)
    }
  }}

}