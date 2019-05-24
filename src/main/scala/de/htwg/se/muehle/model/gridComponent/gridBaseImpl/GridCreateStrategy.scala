package de.htwg.se.muehle.model.gridComponent.gridBaseImpl

trait GridCreateStrategy {

  def createNewGrid(charArray: Array[Char]): Grid = {
    var grid = new Grid(charArray)
    grid = prepare(grid)
    grid = setGrid(grid)
    grid
  }

  def prepare(grid: Grid):Grid = {
    // by default do nothing
    grid
  }

  def setGrid(grid: Grid) : Grid // abstract
}
