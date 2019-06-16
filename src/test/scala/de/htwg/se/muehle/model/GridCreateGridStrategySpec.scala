package de.htwg.se.muehle.controller


import de.htwg.se.muehle.model.gridComponent.gridBaseImpl._
import org.scalatest.{Matchers, WordSpec}

class GridCreateGridStrategySpec extends WordSpec with Matchers{
  "A Strategy" when { "new" should {
    val grid = Grid(init = true)
    val strategy_grid = new GridCreateGridStrategy
    "should create new Grid" in {
      strategy_grid.setGrid(grid) shouldBe(true)
    }
  }}
}