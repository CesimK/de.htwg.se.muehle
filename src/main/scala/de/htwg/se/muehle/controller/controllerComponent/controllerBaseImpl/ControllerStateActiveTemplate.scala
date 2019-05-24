package de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl

import de.htwg.se.muehle.model.playerComponent.Player

trait ControllerStateActiveTemplate {

  def setActive(controller: Controller):Unit = {
    switchActivePlayerPlaced(controller)
    switchActivePlayerMoved(controller)
  }

  def switchActivePlayerPlaced(controller: Controller): Unit

  def switchActivePlayerMoved(controller: Controller): Unit
}
