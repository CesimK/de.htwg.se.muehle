package de.htwg.se.muehle.model.gridComponent.gridBaseImpl

class GridCreateGridStrategy extends GridCreateStrategyTemplate{

  def setGrid(_grid:Grid): Grid = Grid(init = true)

}