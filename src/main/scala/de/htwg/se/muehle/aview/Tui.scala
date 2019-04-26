package de.htwg.se.muehle.model

import model.Field

class Tui () {
  def process_cmd(flag:String, grid:Field):String = {
   flag match {
     case "q" | "quit"        => "Closing the game. All unsaved changes will be lost."
     case "n" | "new"         => "Starting a new game"
     case "m" | "move"        => "Move a Stone to a new position."
     case "u" | "undo"        => "Undo the last turn"
     case "r" | "redo"        => "Redo the last turn"
     case "s" | "save"        => "Save the game"
     case "l" | "load"        => "Load the game"
     case "sur" | "surrender" => "Give up"
     case "h" | "?" | "help"  => this.help_text()
     case _                   => "This command does not exists.\nPlease see the help which commands are allowed."
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
        "sur | surrender:\n"+
        "\tGive up the game. The other player will be declared as winner.\n\n" +
        "h | ? | help:\n"+
        "\tShows this help text."
}
