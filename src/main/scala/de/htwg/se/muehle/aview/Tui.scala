package de.htwg.se.muehle.model;

class Tui {
  def process_cmd(flag:String, grid:Matrix[T]):Matrix[T] = {
   flag match {
     case 'q' | 'quit'        => println("This function is without function yet" )
     case 'n' | 'new'         => println("This function is without function yet" )
     case 'm' | 'move'        => println("This function is without function yet" )
     case 'u' | 'undo'        => println("This function is without function yet" )
     case 'r' | 'redo'        => println("This function is without function yet" )
     case 's' | 'save'        => println("This function is without function yet" )
     case 'l' | 'load'        => println("This function is without function yet" )
     case 'sur' | 'surrender' => println("This function is without function yet" )
     case 'h' | '?' | 'help'  => println("This function is without function yet" )
     case _                   => println("This function is without function yet" )

   }

  }
}