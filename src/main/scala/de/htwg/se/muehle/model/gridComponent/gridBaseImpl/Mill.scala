package de.htwg.se.muehle.model.gridComponent.gridBaseImpl

import scala.io.Source
import scala.collection.mutable.Map

object Mill{
  def connectMills(mills: List[(Int, Int, Int)]) {
    val file: Source = Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("mills.txt"))
    for (line <- file.getLines()) mills.::(line)
  }
  
  def parse_file(vertex: Map[Int, List[Int]]):Unit = {
    val f_vertex: Source = Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("vertex.txt"))
    for (line <- f_vertex.getLines()) {
      val tokens = line.split(" ")
      if(vertex.contains(tokens(0).toInt)) {
        vertex(tokens(0).toInt) = vertex(tokens(0).toInt).::(tokens(1).toInt)
      } else {
        vertex += (tokens(0).toInt -> List().::(tokens(1).toInt))
      }
    }
}

case class Mill(var mills: List[(Int, Int, Int)] = List()) {
  var vertex:Map[Int, List[Int]] = Map[Int, List[Int]]()
  import Mill._
  connectMills(mills)
  parse_file(vertex)
  }
}

