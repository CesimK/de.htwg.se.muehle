package model.gridComponent

trait IGrid {

  def empty_grid:Array[Char]
  def is_free (x: Int): Boolean
}