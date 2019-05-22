package de.htwg.se.muehle.controller

import de.htwg.se.muehle.model.playerComponent.Player

class ControllerStateActivePlaced extends ControllerStateActiveTemplate {

  def switchActivePlayerPlaced(p1: Player, p2:Player): Unit = {
    var p1:Player = p1
    var p2:Player = p2
    var active = p1
    if (active.name.equals(p1.name)) {
      p1 = Player(p1.name, p1.color, p1.placed + 1)
      active = p2
    } else {
      p2 = Player(p2.name, p2.color, p2.placed + 1)
      active = p1
    }
  }

  override def switchActivePlayerMoved(p1: Player, p2: Player): Unit = Option
}
