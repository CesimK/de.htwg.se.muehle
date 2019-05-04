package de.htwg.se.muehle.controller

import de.htwg.se.muehle.model.{Field, Player}
import de.htwg.se.muehle.util.Observable

class Controller(var grid:Field, var p1:Player, var p2:Player) extends Observable{
  var active:Player = p1

  def createEmptyGrid():Unit = {
    grid = Grid(init = true)
    notifyObservers
  }

  def gridToString: String = grid.toString

  def placeStone(pos:Int):Unit = {
    if (active.placed >= 9 || grid.filled(pos) != grid.empty_grid(pos)) {
      notifyObservers
      return
    }
    val edit_grid = grid.filled
    edit_grid(pos) = active.color
    grid = Field(edit_grid, num_fields = grid.num_fields)
    if (active.name.equals(p1.name)) {
      p1 = Player(p1.name, p1.color, p1.placed + 1)
      active = p2
    } else {
      p2 = Player(p2.name, p2.color, p2.placed + 1)
      active = p1
    }
    notifyObservers
  }

}