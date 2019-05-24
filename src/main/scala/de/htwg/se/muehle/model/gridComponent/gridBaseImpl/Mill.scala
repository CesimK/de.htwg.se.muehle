package de.htwg.se.muehle.model.gridComponent.gridBaseImpl

import scala.io.Source
import scala.collection.mutable.Map

case class Mill(var mills: List[(Int, Int, Int)] = List()) {
  val file: Source = Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("mills.txt"))
  for (line <- file.getLines()) mills.::(line)
  val f_vertex: Source = Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("vertex.txt"))
  var vertex:Map[Int, List[Int]] = Map[Int, List[Int]]()
  parse_file(f_vertex)

  def parse_file(source: Source):Unit = {
    for (line <- source.getLines()) {
      val tokens = line.split(" ")
      if(vertex.contains(tokens(0).toInt)) {
        vertex(tokens(0).toInt) = vertex(tokens(0).toInt).::(tokens(1).toInt)
      } else {
        vertex += (tokens(0).toInt -> List().::(tokens(1).toInt))
      }
    }
  }
}
