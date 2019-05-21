package de.htwg.se.muehle.controller

import de.htwg.se.muehle.util.Observable
import de.htwg.se.muehle.model.gridComponent.gridBaseImpl.{Grid, GridCreateGridStrategy}
import de.htwg.se.muehle.model.playerComponent.Player

class Controller(var grid:Grid, var p1:Player, var p2:Player) extends Observable{
  var active:Player = p1
  var status:String = ""
  val stateP = new ControllerStateStatusPlaced
  val stateM = new ControllerStsteStatusMoved
  val active_Player = new ControllerStateActiveTemplate

  def newGame():Unit = {
    grid = (new GridCreateGridStrategy).setGrid(grid)
    p1 = Player(p1.name, 'W')
    p2 = Player(p2.name, 'B')
    active = p1
    notifyObservers
  }

  def gridToString: String = grid.toString

  def placeStone(pos:Int):Unit = {
    if (active.stones != 9 || active.placed >= 9) {
      stateP.allStonesPlaced(status)
      notifyObservers
      return
    }
    if (grid.filled(pos) != grid.empty_grid(pos)) {
      stateP.slotIsFilled(status)
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

  def moveStone(src:Int, pos:Int):Unit = {
    if (active.placed != 9) {
      stateM.stonesStillAvailable(status)
      notifyObservers
      return
    }
    if (!grid.filled(src).equals(active.color)) {
      stateM.selectedFieldInvalid(status)
      notifyObservers
      return
    }
    if (!grid.is_free(pos)) {
      stateM.selectedFieldNotEmpty(status)
      notifyObservers
      return
    }
    val edit_grid = grid.filled
    edit_grid(pos) = active.color
    edit_grid(src) = grid.empt_val
    grid = Grid(edit_grid, num_fields = grid.num_fields)
    if (active.name.equals(p1.name)) {
      active = p2
    } else {
      active = p1
    }
    notifyObservers
  }

}