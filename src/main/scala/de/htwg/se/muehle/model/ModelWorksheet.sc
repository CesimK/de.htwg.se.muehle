import scala.io.Source

var mills: List[(Int, Int, Int)] = List()
val file: Source = Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("mills.txt"))
for (line <- file.getLines()) {
  println(mills.::(line))
  println(mills)
}
