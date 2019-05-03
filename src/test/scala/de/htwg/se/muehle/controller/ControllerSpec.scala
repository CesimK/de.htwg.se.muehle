package de.htwg.se.muehle.controller


import org.scalatest.{Matchers, WordSpec}
import de.htwg.se.muehle.model.Field
import de.htwg.se.muehle.util.Observer

class ControllerSpec extends WordSpec with Matchers {
  val grid = Field()
  val controller = new Controller(grid)
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

}
