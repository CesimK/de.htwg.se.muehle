package de.htwg.se.muehle.model

import org.scalatest._

@Ignore
class GridSpec extends WordSpec with Matchers {
  "A Grid" when { "new" should {
    val grid = Grid()
    "the grid size will be by default 7 times 7"  in {
      grid.size should be(7)
    }
    "the amount a total fields will be 49" in {
      grid.fields should be(49)
    }
    "but 49 fields are to much accesible fields for this game. " +
      "So, only 24 fields can be accessed and stones can only be placed in these." in {
      grid.active_fields should be(24)
    }
    "all cells within the grid are empty in the beginning." in {
      grid.filled_fields() should be(0)
    }
  }}
}
