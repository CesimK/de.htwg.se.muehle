package de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl

trait ControllerStateStatus {

  def setStatePlaceStones(status:String):Unit = {
    allStonesPlaced(status)
    slotIsFilled(status)
  }

  def setStateMoveStones(status:String):Unit = {
    stonesStillAvailable(status)
    selectedFieldInvalid(status)
    selectedFieldNotEmpty(status)
    selectedFieldNotReachable
  }

  def selectedFieldNotReachable: Unit

  def allStonesPlaced(status:String): Unit

  def slotIsFilled(status:String): Unit

  def stonesStillAvailable(status:String): Unit

  def selectedFieldInvalid(status:String): Unit

  def selectedFieldNotEmpty(status:String): Unit
}
