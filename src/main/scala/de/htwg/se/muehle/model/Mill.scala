package de.htwg.se.muehle.model

import scala.io.Source

case class Mill(var mills: List[(Int, Int, Int)] = List()) {
  val file: Source = Source.fromFile("Z:\\Git\\de.htwg.se.muehle\\src\\main\\resources\\mills.txt")
  for (line <- file.getLines()) mills.::(line)
}

