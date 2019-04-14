package de.htwg.se.muehle.model

import scala.io.StdIn.readLine

object Muehle {
  val tui = new Tui
  val grid = new Grid()

  def main(args: Array[String]): Unit = {
    var input: String = ""
    val player1 = Player("Cesim Keskin", "White")
    println("Hello, " + player1.name)
    val player2 = Player("Christopher Gogl", "Black")
    println("Hello, " + player2.name)

    do {
      input = readLine()
      tui.process_cmd(input, grid)
    }
  }
}
