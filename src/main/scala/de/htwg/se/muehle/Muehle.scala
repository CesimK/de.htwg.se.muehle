package de.htwg.se.muehle

import de.htwg.se.muehle.model.{Field, Player}
import de.htwg.se.muehle.controller.Controller
import de.htwg.se.muehle.aview.Tui

object Muehle {

  def main(args: Array[String]): Unit = {
    var input: String = ""
    val player1 = Player("Cesim Keskin", 'W')
    println("Hello, " + player1.name)
    val player2 = Player("Christopher Gogl", 'B')
    println("Hello, " + player2.name)

    val field = Field()
    val controller = new Controller(field, player1, player2)
    val tui = new Tui(controller)
    do {
      input = scala.io.StdIn.readLine()
      tui.process_cmd(input)
    } while (input != "q" && input != "quit")
  }
}
