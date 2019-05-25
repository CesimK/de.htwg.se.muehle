package de.htwg.se.muehle

import controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.muehle.aview.Tui
import de.htwg.se.muehle.aview.gui.Gui
import model.gridComponent.gridBaseImpl.Grid
import model.playerComponent.Player

object Muehle {

  def main(args: Array[String]): Unit = {
    var input: String = ""
    val player1 = new Player("Cesim Keskin", 'W')
    println("Hello, " + player1.name)
    val player2 = new Player("Christopher Gogl", 'B')
    println("Hello, " + player2.name)

    val field = Grid(init = true)
    val controller = new Controller(field, player1, player2)
    val tui = new Tui(controller)
    val gui = new Gui(controller)
    do {
      input = scala.io.StdIn.readLine()
      tui.process_cmd(input)
    } while (input != "q" && input != "quit")
  }
}
