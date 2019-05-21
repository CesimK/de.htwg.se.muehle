package de.htwg.se.muehle.controller

class ControllerStsteStatusMoved extends ControllerStateTemplate {

  def stonesStillAvailable(status: String): Unit = println("Place all stones before moving one.")

  def selectedFieldInvalid(status: String): Unit = println("At the selected field is none of your stones placed.")

  def selectedFieldNotEmpty(status: String): Unit = println("On this field is already a stone placed.\nChoose another field to place your stone.")

  override def allStonesPlaced(status: String): Unit = Option

  override def slotIsFilled(status: String): Unit = Option
}
