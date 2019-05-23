package de.htwg.se.muehle.model.gridComponent

trait IGrid {

  def empty_grid:Array[Char]
  def is_free (x: Int): Boolean
}
