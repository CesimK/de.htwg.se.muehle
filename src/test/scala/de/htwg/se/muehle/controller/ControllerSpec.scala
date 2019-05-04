package de.htwg.se.muehle.controller


import org.scalatest.{Matchers, WordSpec}
import de.htwg.se.muehle.model.{Field, Player}
import de.htwg.se.muehle.util.Observer

class ControllerSpec extends WordSpec with Matchers {
  val grid = Field()
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
        controller.createEmptyGrid()
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
  }
}
