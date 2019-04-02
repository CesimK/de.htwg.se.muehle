package de.htwg.se.muehle.model

object Muehle {
  def main(args: Array[String]): Unit = {
    val player1 = Player("Cesim Keskin")
    println("Hello, " + player1.name)
    val player2 = Player("Christopher Gogl")
    println("Hello, " + player2.name)
  }
}
