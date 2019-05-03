package de.htwg.se.muehle.controller

import de.htwg.se.muehle.model.Grid
import de.htwg.se.muehle.util.Observable

class Controller(var grid:Grid) extends Observable{
  def createEmptyGrid():Unit = {
    grid = Grid(init = true)
    notifyObservers
  }

  def gridToString: String = grid.toString

}