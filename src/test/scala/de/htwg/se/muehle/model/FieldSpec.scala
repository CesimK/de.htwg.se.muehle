package de.htwg.se.muehle.model

import org.scalatest.{Matchers, WordSpec}

class FieldSpec extends WordSpec with Matchers {
  "A Field" when( "new" should{
    val vector = Vector[Cell](Cell())
    val matrix = Matrix[Cell](Vector[Vector[Cell]](vector))
    "connect 2 Cells with each other" in {
      
    }
  })
}
