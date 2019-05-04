package de.htwg.se.muehle.aview

import de.htwg.se.muehle.controller.Controller
import de.htwg.se.muehle.util.Observer

class Tui (val controller: Controller) extends Observer{
  controller.add(this)

  def process_cmd(cmd:String):Unit = {
    val tokens = cmd.split(" ")
    tokens(0) match {
      case "q" | "quit"          => println("Closing the game. All unsaved changes will be lost.")
      case "n" | "new" | "reset" => controller.createEmptyGrid()
      case "m" | "move"          => println("Move a Stone to a new position.")
      case "u" | "undo"          => println("Undo the last turn")
      case "r" | "redo"          => println("Redo the last turn")
      case "s" | "save"          => println("Save the game")
      case "l" | "load"          => println("Load the game")
      case "p" | "place"         => controller.placeStone(tokens(1).toInt - 1)
      case "sur" | "surrender"   => println("Give up")
      case "h" | "?" | "help"    => println(this.help_text())
      case _                     => println("This command does not exists.\nPlease see the help which commands are allowed.")
   }
  }

  def help_text():String =
      "The following commands can be used to controll the game.\n"+
        "To get more information about a command use:\n" +
        "\t<h|help> <command>\n\n" +
        "q | quit:\n" +
        "\tClose the game. The actual progress won't be saved. All changes are lost.\n\n" +
        "n | new:\n"+
        "\tStart a new game. The current progress get lost and won't be saved.\n\n" +
        "m | move:\n"+
        "\tMove a Stone from one field to another.\n\n" +
        "u | undo:\n"+
        "\tUndo the last turn.\n\n" +
        "r | redo:\n"+
        "\tRedo the last undo turn.\n\n" +
        "s | save:\n"+
        "\tSave the current state of the game.\n\n" +
        "l | load:\n"+
        "\tLoad a previous saved game.\n\n" +
        "p | place\n" +
        "\tTo place stones in the beginning of the game." +
        "sur | surrender:\n" +
        "\tGive up the game. The other player will be declared as winner.\n\n" +
        "h | ? | help:\n" +
        "\tShows this help text."

  override def update: Unit = println(controller.gridToString)
}
