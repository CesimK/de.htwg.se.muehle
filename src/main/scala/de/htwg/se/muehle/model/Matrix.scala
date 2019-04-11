package de.htwg.se.muehle.model

case class Matrix[T](grid:Vector[Vector[T]]) {
  val rows:Int = grid.length()
  val cols:Int = grid.head.length()
  override def size:Int rows * cols
}