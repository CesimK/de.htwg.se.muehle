package de.htwg.se.muehle.controller

import de.htwg.se.muehle.model.playerComponent.Player

trait ControllerStateActiveTemplate {

  def setActive(p1:Player, p2:Player):Unit = {
    switchActivePlayer(p1,p2)
  }

  def switchActivePlayer(p1:Player, p2:Player): Unit
}
