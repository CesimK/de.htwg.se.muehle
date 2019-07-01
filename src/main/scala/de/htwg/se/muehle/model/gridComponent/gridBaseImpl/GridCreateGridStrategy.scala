package de.htwg.se.muehle.model.gridComponent.gridBaseImpl

import de.htwg.se.muehle.model.gridComponent.IGrid

class GridCreateGridStrategy extends GridCreateStrategy{
  // $COVERAGE-OFF$
  def setGrid(_grid:IGrid): Grid = Grid(init = true)
  // $COVERAGE-ON$
}