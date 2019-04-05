package de.htwg.se.muehle.model;

case class Stone(owner: Player, team: String, cell: Cell = null) {
  override def toString:String = team + " Stone\nfor Player: " + owner
}
