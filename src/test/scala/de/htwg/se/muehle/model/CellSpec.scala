package de.htwg.se.muehle.model

import org.scalatest._

@Ignore
class CellSpecold extends WordSpec with Matchers {
  "A Cell" when { "new" should {
    val cell = Cell()
    "should be empty"  in {
      cell.isfree should be("1")
    }
  }}
}
