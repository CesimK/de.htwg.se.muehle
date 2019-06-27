package de.htwg.se.muehle

import com.google.inject.Guice
import controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.muehle.aview.Tui
import de.htwg.se.muehle.aview.gui.Gui
import de.htwg.se.muehle.controller.controllerComponent.IController
import model.gridComponent.gridBaseImpl.Grid
import model.playerComponent.Player

object Muehle {

  def main(args: Array[String]): Unit = {
    var input: String = ""

    val injector = Guice.createInjector(new MuehleModule)
    val controller = injector.getInstance(classOf[IController])
    val tui = new Tui(controller)
    val gui = new Gui(controller)
    do {
      input = scala.io.StdIn.readLine()
      tui.process_cmd(input)
    } while (input != "q" && input != "quit")
    System.exit(0)
  }
}
