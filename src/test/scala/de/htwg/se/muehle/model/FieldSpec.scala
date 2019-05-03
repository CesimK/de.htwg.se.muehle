package de.htwg.se.muehle.model

import org.scalatest.{Matchers, WordSpec}

class FieldSpec extends WordSpec with Matchers {
  "A Field" when { "new" should {
      val field = Field(init = true)
      "create a Grid" in {
        field.empty_grid.length should be(field.num_fields)
        for (i <- field.empty_grid) i.toString should be (field.empty_field)
      }
      "create a String to display" in {
        val def_out = "O-----O-----O\n" +
          "| O---O---O |\n" +
          "| | O-O-O | |\n" +
          "O-O-O   O-O-O\n" +
          "| | O-O-O | |\n" +
          "| O---O---O |\n" +
          "O-----O-----O\n"
        field.toString should be (def_out)
      }
    }
  }
}
