package de.htwg.se.muehle.model.gridComponent

import scala.collection.mutable.Map

trait IGrid {

  def empty_grid:Array[Char]
  def is_free (x: Int): Boolean
}

trait IMill {
  def parse_file(vertex: Map[Int, List[Int]]):Unit
  def connectMills(mills: List[(Int, Int, Int)])
}