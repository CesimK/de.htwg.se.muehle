package de.htwg.se.muehle.controller

import de.htwg.se.muehle.model.{Grid, Player}
import de.htwg.se.muehle.util.Observable

class Controller(var grid:Grid, var p1:Player, var p2:Player) extends Observable{
  var active:Player = p1
  var status:String = ""

  def newGame():Unit = {
    grid = Grid(init = true)
    p1 = new Player(p1.name, 'W')
    p2 = new Player(p2.name, 'B')
    active = p1
    notifyObservers
  }

  def gridToString: String = grid.toString

  def placeStone(pos:Int):Unit = {
    if (active.stones != 9 || active.placed >= 9) {
      status = "All Stones are already placed.\n" +
               "To move a stone use the 'move' command."
      notifyObservers
      return
    }

    if (grid.filled(pos) != grid.empty_grid(pos)) {
      status = "This field is already blocked.\n" +
               "Select another field to place your stone."
      notifyObservers
      return
    }

    val edit_grid = grid.filled
    edit_grid(pos) = active.color
    grid = Grid(edit_grid, num_fields = grid.num_fields)
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