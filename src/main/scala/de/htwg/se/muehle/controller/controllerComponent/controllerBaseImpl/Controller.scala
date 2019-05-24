package de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl

import de.htwg.se.muehle.controller.controllerComponent.IController
import de.htwg.se.muehle.controller.controllerComponent.commands.{MoveCommand, PlaceCommand}
import de.htwg.se.muehle.model.gridComponent.gridBaseImpl.{Grid, GridCreateGridStrategy}
import de.htwg.se.muehle.model.gridComponent.gridBaseImpl.Mill.Mill
import de.htwg.se.muehle.model.playerComponent.Player
import de.htwg.se.muehle.util.{Observable, UndoManager}

class Controller(var grid:Grid, var p1:Player, var p2:Player) extends Observable with IController {
  var active:Player = p1
  var status:String = ""
  val mills:Mill = Mill()
  val state_Placed = new ControllerStateStatusPlaced
  val state_Moved = new ControllerStateStatusMoved
  val active_Placed = new ControllerStateActivePlaced
  val active_Moved = new ControllerStateActiveMoved

  private val undo_manager = new UndoManager

  override def newGame():Unit = {
    grid = (new GridCreateGridStrategy).setGrid(grid)
    p1 = Player(p1.name, 'W')
    p2 = Player(p2.name, 'B')
    active = p1
    notifyObservers
  }

  override def gridToString: String = grid.toString

  override def placeStone(pos:Int):Unit = {
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
    undo_manager.doStep(new PlaceCommand(this, pos))
    notifyObservers
  }

  override def moveStone(src:Int, pos:Int):Unit = {
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
    undo_manager.doStep(new MoveCommand(this, src, pos))
    notifyObservers
  }

  def undo: Unit = {
    undo_manager.undoStep
    notifyObservers
  }

  def redo: Unit = {
    undo_manager.redoStep
    notifyObservers
  }

  def isNeighbour(src:Int, dest:Int): Boolean = mills.vertex(src).contains(dest)
}