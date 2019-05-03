package de.htwg.se.muehle.controller

import de.htwg.se.muehle.model.Field
import de.htwg.se.muehle.util.Observable

class Controller(var grid:Field) extends Observable{
  def createEmptyGrid():Unit = {
    grid = Field(init = true)
    notifyObservers
  }

  def gridToString: String = grid.toString

}