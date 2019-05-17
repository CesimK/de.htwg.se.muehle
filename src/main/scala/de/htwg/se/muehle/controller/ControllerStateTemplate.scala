package de.htwg.se.muehle.controller

trait ControllerStateTemplate {

  def setActivePlayer(): Unit = {

  }

  def setState(status:String):Unit = {
    allStonesPlaced(status)
    slotIsFilled(status)
    stonesStillAvailable(status)
    selectedFieldInvalid(status)
    selectedFieldNotEmpty(status)
  }

  def allStonesPlaced(status:String): Unit

  def slotIsFilled(status:String): Unit

  def stonesStillAvailable(status:String): Unit

  def selectedFieldInvalid(status:String): Unit

  def selectedFieldNotEmpty(status:String): Unit
}
