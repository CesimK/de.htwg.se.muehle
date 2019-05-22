package de.htwg.se.muehle.controller

import de.htwg.se.muehle.model.playerComponent.Player

trait ControllerStateActiveTemplate {

  def setActive(p1:Player, p2:Player):Unit = {
    switchActivePlayerPlaced(p1,p2)
    switchActivePlayerMoved(p1,p2)
  }

  def switchActivePlayerPlaced(p1:Player, p2:Player): Unit

  def switchActivePlayerMoved(p1:Player, p2:Player): Unit
}
