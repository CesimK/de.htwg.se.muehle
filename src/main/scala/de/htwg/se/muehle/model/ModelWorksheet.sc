import scala.io.Source

val file: Source = Source.fromFile("Z:\\Git\\de.htwg.se.muehle\\src\\main\\scala\\de\\htwg\\se\\muehle\\util\\GridEdges.txt")
for (i <- file.getLines()){
  val a = i.split(" ")(0).toInt
  val b = i.split(" ")(1).toInt
  println("node A: " + a)
  println("node B: " + b)
  println("-------------------------------")
}

val file2: Source = Source.fromFile("Z:\\Git\\de.htwg.se.muehle\\src\\main\\scala\\de\\htwg\\se\\muehle\\util\\mills.txt")
for (x <- file2.getLines()){
  val a = x.split(" ")(0).toInt
  val b = x.split(" ")(1).toInt
  val c = x.split(" ")(2).toInt
  println("node A: " + a)
  println("node B: " + b)
  println("node C: " + c)
  println("-------------------------------")
}