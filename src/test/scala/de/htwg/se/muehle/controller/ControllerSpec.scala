package de.htwg.se.muehle.controller


import org.scalatest.{Matchers, WordSpec}
import de.htwg.se.muehle.model.Field
import de.htwg.se.muehle.util.Observer

class ControllerSpec extends WordSpec with Matchers {
  "A new Controller" when {
    "observed by an Observer" should {
      val grid = Field()
      val controller = new Controller(grid)
      val observer = new Observer {
        var updated: Boolean = false

        def isUpdated: Boolean = updated

        override def update: Unit = updated = true
      }
      controller.add(observer)
      "notify its Observer after creation" in {
        controller.createEmptyGrid()
        observer.updated should be(true)
        controller.grid.number_vertexes should be(24)
      }
      "can ask its grid to create a String to display" in {
        val def_out = "x-----x-----x" +
                      "| x---x---x |" +
                      "| | x-x-x | |" +
                      "x-x-x   x-x-x" +
                      "| | x-x-x | |" +
                      "| x---x---x |" +
                      "x-----x-----x"
        controller.gridToString should be ()
      }
    }
  }

}
