import scala.io.Source

object Mill{
  def connectMills(mills: List[(Int, Int, Int)]) {
    val file: Source = Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("mills.txt"))
    for (line <- file.getLines()) mills.::(line)
  }
}

case class Mill(var mills: List[(Int, Int, Int)] = List()) {
  import Mill._
  connectMills(mills)
}