package de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl

import de.htwg.se.muehle.model.playerComponent.Player

class ControllerStateActivePlaced extends ControllerStateActiveTemplate {

  def switchActivePlayerPlaced(controller: Controller): Unit = {
    if (controller.active.name.equals(controller.p1.name)) {
      controller.p1 = Player(controller.p1.name, controller.p1.color, controller.p1.placed + 1)
      controller.active = controller.p2
    } else {
      controller.p2 = Player(controller.p2.name, controller.p2.color, controller.p2.placed + 1)
      controller.active = controller.p1
    }
  }

  override def switchActivePlayerMoved(controller: Controller): Unit = Option
}
