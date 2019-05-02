package de.htwg.se.muehle.controller

import de.htwg.se.muehle.model.{Grid, Solver, GridCreator}
import de.htwg.se.muehle.util.Observable

class Controller(var grid:Field) extends Observable{
  def createEmptyGrid():Unit = {
    grid = new Field()
    notifyObservers
  }

  def gridToString: String = grid.toString

  def set(row: Int, col: Int, value: Int):Unit = {
    grid = grid.set(row, col, value)
    notifyObservers
  }
}