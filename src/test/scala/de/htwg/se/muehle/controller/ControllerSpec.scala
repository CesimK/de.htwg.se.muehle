package de.htwg.se.muehle.controller


import org.scalatest.{Matchers, WordSpec}
import de.htwg.se.muehle.model.gridComponent.gridBaseImpl.Grid
import de.htwg.se.muehle.model.playerComponent.Player
import de.htwg.se.muehle.util.Observer

class ControllerSpec extends WordSpec with Matchers {
  val grid = Grid()
  val player1 = Player("Person 1", 'W')
  val player2 = Player("Person 2", 'B')
  val controller = new Controller(grid, player1, player2)

  val observer = new Observer {
    var updated: Boolean = false

    def isUpdated: Boolean = updated

    override def update: Unit = updated = true
  }
  "A new Controller" when {
    "observed by an Observer" should {
      controller.add(observer)
      "notify its Observer after creation" in {
        controller.newGame()
        observer.updated should be(true)
        controller.grid.init should be (true)
        controller.grid.num_fields should be(24)
      }
      "can ask its grid to create a String to display" in {
        val def_out = "O-----O-----O\n" +
                      "| O---O---O |\n" +
                      "| | O-O-O | |\n" +
                      "O-O-O   O-O-O\n" +
                      "| | O-O-O | |\n" +
                      "| O---O---O |\n" +
                      "O-----O-----O\n"
        controller.gridToString should be (def_out)
      }
    }
    "When the observer is outdated or execution finished" should {
      "the observer can be removed" in {
        controller.remove(observer)
        controller.subscribers should be (Vector.empty)
      }
    }
  }
  "Both players can place stones in the beginning" when {
    "The first turn is Player 1 turn " in {
      controller.active should be (controller.p1)
    }
    "The first player can place its stone everywhere" in {
      controller.grid.filled should not contain controller.p1.color
      controller.placeStone(0)
      controller.grid.filled should contain (controller.p1.color)
    }
    "After Player 1 turn it is automatically Player 2 tuen" in {
      controller.active should be (controller.p2)
    }
    "If Player 2 tries to plac his stone in the sam field it will fail." +
    "Also it is still Player 2 turn" in {
      controller.grid.filled should not contain controller.p2.color
      controller.grid.filled should contain (player1.color)
      controller.placeStone(0)
      controller.grid.filled should not contain controller.p2.color
      controller.grid.filled should contain (player1.color)
      controller.active should be (player2)
    }
    "After an allowed turn Player 1 will continue" in {
      controller.grid.filled should not contain controller.p2.color
      controller.placeStone(1)
      controller.grid.filled should contain (controller.p2.color)
      controller.active should be (controller.p1)
    }
    "the Player cannot move his stones until all are placed" in {
      val ref = controller.grid.filled
      controller.moveStone(0, 23)
      controller.grid.filled should be (ref)

    }
    "A Player that has placed all his stones, cannot place more." in {
      controller.p1 = new Player(controller.p1.name, controller.p1.color, 9)
      controller.p1.placed should be (9)
      controller.active = controller.p1
      val tmp = controller.grid.filled
      controller.placeStone( 2)
      controller.grid.filled should be (tmp)
    }
    "But now he can start to move stones" when {
      "the field is not already in use. When in use noting should change." in {
        controller.p1 = new Player(controller.p1.name, controller.p1.color, 9)
        controller.p2 = new Player(controller.p2.name, controller.p2.color, 9)
        controller.p1.placed should be (9)
        controller.p2.placed should be (9)
        controller.active = controller.p1
        controller.grid = new Grid((("W"*9)+("B"*9)+("O"*6)).toCharArray)
        val ref = controller.grid.filled
        controller.moveStone(0, 1)
        controller.grid.filled should be (ref)
        controller.active should be (controller.p1)
        controller.moveStone(9, 10)
        controller.grid.filled should be (ref)
        controller.active should be (controller.p1)
      }
      "the field is still be free, the stone will move" in {
        controller.moveStone(0, 23)
        controller.grid.filled(0) should be (controller.grid.empt_val)
        controller.grid.filled(23) should be (controller.p1.color)
        controller.active should be (controller.p2)
      }
      "Also the other player can move his stones." in {
        controller.active should be (controller.p2)
        controller.moveStone(10, 22)
        controller.grid.filled(10) should be (controller.grid.empt_val)
        controller.grid.filled(22) should be (controller.p2.color)
        controller.active should be (controller.p1)
      }
    }
  }
}
