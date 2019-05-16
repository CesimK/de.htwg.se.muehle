package model.gridComponent.gridBaseImpl

import scala.util.Random

class GridCreateRandomStrategy extends GridCreateStrategyTemplate{

  def fill(_grid:Grid): Grid = {
    val num = Math.sqrt(_grid.num_fields).toInt
    var grid = new Grid(_grid.empty_grid)
    for {i <- 1 to num} {
      grid = setCell(grid)
    }
    grid
  }

  private def setCell(grid:Grid): Grid = {
    val pos = Random.nextInt(grid.num_fields)
    val availableValueSet = grid.empty_grid
    val numAvailableValues = availableValueSet.length
    if (numAvailableValues > 0) {
      val value = availableValueSet(Random.nextInt(numAvailableValues))
      grid.empty_grid
    }
  }
}