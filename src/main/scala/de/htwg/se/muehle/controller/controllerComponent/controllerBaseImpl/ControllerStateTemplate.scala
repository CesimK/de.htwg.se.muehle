package controller.controllerComponent.controllerBaseImpl

trait ControllerStateTemplate {

  def setStatePlaceStones(status:String):Unit = {
    allStonesPlaced(status)
    slotIsFilled(status)
  }

  def setStateMoveStones(status:String):Unit = {
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
