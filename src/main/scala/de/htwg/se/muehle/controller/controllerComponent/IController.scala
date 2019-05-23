package de.htwg.se.muehle.controller.controllerComponent

trait IController {

  def newGame():Unit
  def gridToString: String
  def placeStone(pos:Int):Unit
  def moveStone(src:Int, pos:Int):Unit
}
