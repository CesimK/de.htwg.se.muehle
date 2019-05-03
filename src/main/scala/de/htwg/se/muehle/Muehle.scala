package de.htwg.se.muehle.model

import de.htwg.se.muehle.model.{Field, Player}
import de.htwg.se.muehle.controller.Controller
import de.htwg.se.muehle.aview.Tui

object Muehle {
  val field = new Field()
  val controller = new Controller(field)
  val tui = new Tui(controller)

  def main(args: Array[String]): Unit = {
    var input: String = ""
    val player1 = Player("Cesim Keskin", "White")
    println("Hello, " + player1.name)
    val player2 = Player("Christopher Gogl", "Black")
    println("Hello, " + player2.name)

    do {
      input = scala.io.StdIn.readLine()
      tui.process_cmd(input)
    } while (input != "q" && input != "quit")
  }
}
