package de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl

class ControllerStateStatusPlaced extends ControllerStateTemplate {

  def allStonesPlaced(status:String): Unit = println("All Stones are already placed.\nTo move a stone use the 'move' command.")

  def slotIsFilled(status: String): Unit = println("This field is already blocked.\nSelect another field to place your stone.")

  override def stonesStillAvailable(status: String): Unit = Option

  override def selectedFieldInvalid(status: String): Unit = Option

  override def selectedFieldNotEmpty(status: String): Unit = Option
}
