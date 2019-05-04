package de.htwg.se.muehle.model

case class Player(name: String, color:Char, placed:Int = 0) {
  val stones:Int = 9
  val jump:Boolean = false

  override def toString:String = "%s (%s)".format(name, color)
}