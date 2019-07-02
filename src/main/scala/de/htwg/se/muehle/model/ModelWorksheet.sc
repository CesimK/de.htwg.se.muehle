import scala.io.Source

class MillsList {
  var millList1 : List[Int] = List()
  var millList2 : List[Int] = List()
}

val NUMBER_VERTEX = 24
var millsArray : Array[MillsList] = new Array[MillsList](NUMBER_VERTEX)


val file = Source.fromInputStream(getClass().getClassLoader().getResourceAsStream("vertex.txt"))


for (line <- file.getLines()) {
  val node = line.split(" ")(0).toInt
  val neighbour = line.split(" ")(1).toInt
  if (line.contains("mill1"))
    millsArray(node).millList1.::(neighbour)
  if(line.contains("mills2"))
    millsArray(node).millList2.::(neighbour)
}

println(millsArray)


