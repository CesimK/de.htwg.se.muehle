package de.htwg.se.muehle.model.gridComponent.gridBaseImpl

import de.htwg.se.muehle.model.gridComponent.IMill

import scala.io.Source
import scala.collection.mutable.Map

object Mill extends IMill {
  override def connectMills(mill: List[(Int, Int, Int)]){
   for (line <- Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("mills.txt")).getLines())
     mill.::(line)
  }

  override def parse_file(vertex: Map[Int, List[Int]]): Unit = {
    for (line <- Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("vertex.txt")).getLines()) {
      val tokens = line.split(" ")
      if (vertex.contains(tokens(0).toInt)) {
        vertex(tokens(0).toInt) = vertex(tokens(0).toInt).::(tokens(1).toInt)
      } else {
        vertex += (tokens(0).toInt -> List().::(tokens(1).toInt))
      }
    }
  }

  case class Mill(var mills: List[(Int, Int, Int)] = List()) {
    var vertex: Map[Int, List[Int]] = Map[Int, List[Int]]()
    connectMills(mills)
    parse_file(vertex)

    def numMills(posList: Array[Int]): Int = {
      var count:Int = 0
      for (entry <- mills) {
        if (posList.contains(entry._1) && posList.contains(entry._2) && posList.contains(entry._3)) {
          count += 1
        }
      }
      count
    }
  }

}

