package de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl

class ControllerStateStatusMoved extends ControllerStateStatus {

  def stonesStillAvailable(status: String): Unit = println("Place all stones before moving one stone.")

  def selectedFieldInvalid(status: String): Unit = println("At the selected field is none of your stones placed.")

  def selectedFieldNotEmpty(status: String): Unit = println("On this field is already a stone placed.\nChoose another field to place your stone.")

  def selectedFieldNotReachable: Unit = println("Target Field is no neighbour of your selected field.")

  override def allStonesPlaced(status: String): Unit = Option

  override def slotIsFilled(status: String): Unit = Option
}
