package de.htwg.se.muehle.aview.gui

import de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.muehle.util.{GridChanged, InvalidTurn}

import scala.swing.BorderPanel.Position.{Center, North, South}
import scala.swing._
import scala.swing.event._

class SrcSelect extends Event
class DestSelect extends Event

class Gui(controller: Controller) extends MainFrame{
  val outFont = new Font("Ariel", java.awt.Font.PLAIN, 24)
  val statFont = new Font("Ariel", java.awt.Font.PLAIN, 16)
  var moveFrom = -1

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

  val canvas = new Canvas(controller) {
    preferredSize = new Dimension(700, 700)
  }
  val status = new Label {
    text = controller.status
    font = statFont
  }

  contents = new BorderPanel {
    layout(statistics) = North
    layout(canvas) = Center
    layout(status) = South
  }

  listenTo(controller)
  listenTo(canvas.mouse.clicks)
  reactions += {
    case MouseClicked(_,point,_,_,_) => {
      val pos = check_clicked(point)
      if (pos >= 0) {
        if (controller.active.placed < 9) controller.placeStone(pos)
        else if (moveFrom == -1) {
          if (controller.checkField(pos)) {
            moveFrom = pos
            controller.highlight(pos) = true
          }
        }
        else if (moveFrom >= 0 && moveFrom <= controller.grid.filled.length) {
          controller.moveStone(moveFrom, pos)
          controller.highlight(moveFrom) = false
          moveFrom = -1
        }
        else moveFrom = -1
      }
      redraw()
    }
    case event:GridChanged => redraw()
    case event:InvalidTurn => redraw()
  }
  centerOnScreen()
  visible = true
  redraw()

  def redraw(): Unit = {
    canvas.redraw()
    activePlayer.text = controller.active.name
    status.text = controller.status
  }

  def check_clicked(point: Point):Int = {
    val gap = size.width/7
    val row:Int = point.y/gap
    val col:Int = point.x/gap
    var offset = 0
    if (row > 3) offset = 3
    var pos = -1
    row match {
      case 0 | 6 => if (List(0,3,6).contains(col)) pos = row*3 + List(0,3,6).indexOf(col) + offset
      case 1 | 5 => if (List(1,3,5).contains(col)) pos = row*3 + List(1,3,5).indexOf(col) + offset
      case 2 | 4 => if (List(2,3,4).contains(col)) pos = row*3 + List(2,3,4).indexOf(col) + offset
      case 3     => if (List(0,1,2,4,5,6).contains(col)) pos = row*3 + List(0,1,2,4,5,6).indexOf(col)
    }
    pos
  }
}