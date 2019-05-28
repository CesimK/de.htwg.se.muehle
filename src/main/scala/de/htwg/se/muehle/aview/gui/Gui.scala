package de.htwg.se.muehle.aview.gui

import de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl.Controller

import scala.swing._
import scala.swing.event._
import java.awt.Color

import scala.swing.BorderPanel.Position.{Center, East, North, South, West}

class SrcSelect extends Event
class DestSelect extends Event

class Gui(controller: Controller) extends MainFrame{
  val outFont = new Font("Ariel", java.awt.Font.PLAIN, 24)
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
    contents += new Menu("Option") {
      mnemonic = Key.O
      contents += new MenuItem(Action("Show Fieldnumber") {
        canvas.numb = !canvas.numb
        redraw()
      })
    }
  }
  val activeLabel = new Label{
    text = "Active Player:"
    font = outFont
  }
  val activePlayer = new Label {
    text = controller.active.name
    font = outFont
  }

  val statistics = new GridPanel(1, 2) {
    contents += activeLabel
    contents += activePlayer
  }
  val p2Label = new Label(controller.p2.name)
  val canvas = new Canvas(controller) {
    preferredSize = new Dimension(700, 700)
  }

  contents = new BorderPanel {
    layout(statistics) = North
    layout(canvas) = Center
  }
  reactions += {
    case _ => redraw()
  }
  visible = true
  redraw()

  def redraw(): Unit = {
    canvas.redraw()
    activePlayer.text = controller.active.name
  }
}
