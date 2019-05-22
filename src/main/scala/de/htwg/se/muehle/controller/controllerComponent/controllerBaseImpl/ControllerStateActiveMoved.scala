package controller.controllerComponent.controllerBaseImpl

import de.htwg.se.muehle.model.playerComponent.Player


class ControllerStateActiveMoved extends ControllerStateActiveTemplate {

  def switchActivePlayerMoved(p1: Player, p2: Player): Unit = {
    val p1:Player = p1
    val p2:Player = p2
    var active = p1
    if (active.name.equals(p1.name)) {
      active = p2
    } else {
      active = p1
    }
  }

  override def switchActivePlayerPlaced(p1: Player, p2: Player): Unit = Option
}
