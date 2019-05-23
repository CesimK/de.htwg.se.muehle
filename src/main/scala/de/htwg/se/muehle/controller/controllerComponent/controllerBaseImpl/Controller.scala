package de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl

import de.htwg.se.muehle.controller.controllerComponent.IController
import de.htwg.se.muehle.model.gridComponent.gridBaseImpl.{Grid, GridCreateGridStrategy}
import de.htwg.se.muehle.model.playerComponent.Player
import de.htwg.se.muehle.util.Observable

class Controller(var grid:Grid, var p1:Player, var p2:Player) extends Observable {
  var active:Player = p1
  var status:String = ""
  val state_Placed = new ControllerStateStatusPlaced
  val state_Moved = new ControllerStsteStatusMoved
  val active_Placed = new ControllerStateActivePlaced
  val active_Moved = new ControllerStateActiveMoved

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
      state_Placed.allStonesPlaced(status)
      notifyObservers
      return
    }
    if (grid.filled(pos) != grid.empty_grid(pos)) {
      state_Placed.slotIsFilled(status)
      notifyObservers
      return
    }

    val edit_grid = grid.filled
    edit_grid(pos) = active.color
    grid = Grid(edit_grid, num_fields = grid.num_fields)
    active_Placed.switchActivePlayerPlaced(this)
    notifyObservers
  }

  def moveStone(src:Int, pos:Int):Unit = {
    if (active.placed != 9) {
      state_Moved.stonesStillAvailable(status)
      notifyObservers
      return
    }
    if (!grid.filled(src).equals(active.color)) {
      state_Moved.selectedFieldInvalid(status)
      notifyObservers
      return
    }
    if (!grid.is_free(pos)) {
      state_Moved.selectedFieldNotEmpty(status)
      notifyObservers
      return
    }
    val edit_grid = grid.filled
    edit_grid(pos) = active.color
    edit_grid(src) = grid.empt_val
    grid = Grid(edit_grid, num_fields = grid.num_fields)
    active_Moved.switchActivePlayerMoved(this)
    notifyObservers
  }

}