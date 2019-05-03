package de.htwg.se.muehle

import de.htwg.se.muehle.model.{Field, Player}
import de.htwg.se.muehle.controller.Controller
import de.htwg.se.muehle.aview.Tui

object Muehle {
  val controller = new Controller(new Field)
  val tui = new Tui(controller)
  val grid = Field()

  def main(args: Array[String]): Unit = {
    var input: String = ""
    val player1 = Player("Cesim Keskin", "White")
    println("Hello, " + player1.name)
    val player2 = Player("Christopher Gogl", "Black")
    println("Hello, " + player2.name)

    do {
      input = scala.io.StdIn()
      tui.process_cmd(input)
    } while (input != "q" && input != "quit")
  }
}
