import de.htwg.se.muehle.model.gridComponent.gridBaseImpl.Mill.getClass

import scala.io.Source
var tmp: List[(Int, Int, Int)] = List()
val file = Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("mills.txt"))
for (line <- file.getLines()) {
  val tokens = line.split(" ")
  val t1 = tokens(0).toInt
  val t2 = tokens(1).toInt
  val t3 = tokens(2).toInt
  val tupel = (t1,t2,t3)
  tmp = tmp.::(tupel)
}
println(tmp)
