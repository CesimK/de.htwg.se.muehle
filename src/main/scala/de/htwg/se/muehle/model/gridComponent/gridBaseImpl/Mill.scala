package model.gridComponent.gridBaseImpl

import scala.io.Source

case class Mill(var mills: List[(Int, Int, Int)] = List()) {
  val file: Source = Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("mills.txt"))
  for (line <- file.getLines()) mills.::(line)
}
