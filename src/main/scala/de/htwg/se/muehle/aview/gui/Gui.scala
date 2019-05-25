package de.htwg.se.muehle.aview.gui

import de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl.Controller

import scala.swing._
import scala.swing.event._
import java.awt.Color

import scala.swing.BorderPanel.Position.{Center, East, North, South, West}

class SrcSelect extends Event
class DestSelect extends Event

class Gui(controller: Controller) extends MainFrame{
  listenTo(controller)
  title = "HTWG Muehle"
  menuBar = new MenuBar {
    contents += new Menu("File") {
      mnemonic = Key.F
      contents += new MenuItem(Action("New")  {controller.newGame()})
      contents += new MenuItem(Action("Quit") {System.exit(0)})
    }
    contents += new Menu("Edit") {
      mnemonic = Key.E
      contents += new MenuItem(Action("Undo") {controller.undo})
      contents += new MenuItem(Action("Redo") {controller.redo})
    }
  }
  val canvas = new Canvas {
    preferredSize = new Dimension(700, 700)
  }

  contents = new BorderPanel {
    layout(canvas) = Center
  }
  visible = true
  canvas.redraw()
}
