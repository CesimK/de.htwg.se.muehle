package de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl

trait ControllerStateActive {
  // $COVERAGE-OFF$
  def setActive(controller: Controller):Unit = {
    switchActivePlayerPlaced(controller)
    switchActivePlayerMoved(controller)
  }
  // $COVERAGE-ON$
  def switchActivePlayerPlaced(controller: Controller): Unit

  def switchActivePlayerMoved(controller: Controller): Unit
}
