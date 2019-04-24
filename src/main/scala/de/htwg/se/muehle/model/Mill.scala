package model

import scala.io.Source

class Mills {

  val number_vertexes = 24
  val file: Source = Source.fromFile("util/mills")
  insertMills(file)
  var mills: Array[MillsList] = new Array[MillsList](number_vertexes)

  for (i <- 0 to mills.length) {
    mills(i) = new MillsList()
    }

  def getMill(v: Int): List[Int] = mills(v - 1).listOfMills

  def insertMills(source: Source): Unit = {
    for (line <- source.getLines()) {

      val first_node = line.split(" ")(0).toInt
      val second_node = line.split(" ")(1).toInt
      val third_node = line.split(" ")(2).toInt

      if (first_node != second_node && first_node != third_node && second_node != third_node)
        mills(first_node).listOfMills.::(second_node).::(third_node)
    }
  }
}

class MillsList {
  var listOfMills: List[Int] = List()
}