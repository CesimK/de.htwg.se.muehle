package de.htwg.se.muehle.controller.controllerComponent

trait IController {

  def newGame():Unit
  def gridToString: String
  def placeStone(pos:Int):Unit
  def moveStone(src:Int, pos:Int):Unit
  def undo: Unit
  def redo: Unit
  def isNeighbour(src:Int, dest:Int): Boolean
}

trait ICommands {
    def doStep: Unit
    def undoStep:Unit
    def redoStep: Unit
}