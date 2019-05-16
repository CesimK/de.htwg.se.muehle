package model.gridComponent.gridBaseImpl

trait GridCreateStrategyTemplate {

  def createNewGrid(grid: Grid): Grid = {
    var grid = new Grid(grid)
    grid = prepare(grid)
    grid = fill(grid)
    grid = postProcess(grid)
    grid
  }

  def prepare(grid: Grid):Grid = {
    // by default do nothing
    grid
  }

  def fill(grid: Grid) : Grid // abstract

  def postProcess(grid: Grid):Grid = { // default implementation
    grid.empty_grid
  }

}
