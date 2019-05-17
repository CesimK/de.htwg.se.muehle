package de.htwg.se.muehle.controller

class ControllerStateStatus extends ControllerStateTemplate {

  def allStonesPlaced(status:String): Unit = println("All Stones are already placed.\nTo move a stone use the 'move' command.")

  def slotIsFilled(status: String): Unit = println("This field is already blocked.\nSelect another field to place your stone.")

  def stonesStillAvailable(status: String): Unit = println("Place all stones before moving one.")

  def selectedFieldInvalid(status: String): Unit = println("At the selected field is none of your stones placed.")

  def selectedFieldNotEmpty(status: String): Unit = println("On this field is already a stone placed.\nChoose another field to place your stone.")
}
