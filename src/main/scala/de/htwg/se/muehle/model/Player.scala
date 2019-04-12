package de.htwg.se.muehle.model

case class Player(name: String, color:String) {
  val stones:Int = 9
  val jump:Boolean = false
  val placed:Int = 0

  override def toString:String = "%s (%s)".format(name, color)
}