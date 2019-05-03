import scala.io.Source

var mills: List[(Int, Int, Int)] = List()
val file: Source = Source.fromFile("Z:\\Git\\de.htwg.se.muehle\\src\\main\\resources\\mills.txt")
for (line <- file.getLines()) {
  println(mills.::(line))
  println(mills)
}
