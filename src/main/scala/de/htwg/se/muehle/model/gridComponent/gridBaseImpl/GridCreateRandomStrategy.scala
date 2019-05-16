package model.gridComponent.gridBaseImpl

import scala.util.Random

class GridCreateRandomStrategy extends GridCreateStrategyTemplate{

  def fill(_grid:Grid): Grid = {
    var grid = new Grid(_grid.empty_grid)
    var pos = Random.nextInt(grid.num_fields)
    _grid = Grid(grid, pos)
  }

}