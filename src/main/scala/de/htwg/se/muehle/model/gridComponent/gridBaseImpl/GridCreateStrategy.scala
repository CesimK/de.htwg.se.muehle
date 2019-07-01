package de.htwg.se.muehle.model.gridComponent.gridBaseImpl

import de.htwg.se.muehle.model.gridComponent.IGrid

trait GridCreateStrategy {

  def createNewGrid(charArray: Array[Char]): Grid = {
    // $COVERAGE-OFF$
    var grid = new Grid(charArray)
    grid = prepare(grid)
    grid = setGrid(grid)
    // $COVERAGE-ON$
    grid
  }

  def prepare(grid: Grid):Grid = {
    // by default do nothing
    grid
  }

  def setGrid(grid: IGrid) : Grid // abstract
}
