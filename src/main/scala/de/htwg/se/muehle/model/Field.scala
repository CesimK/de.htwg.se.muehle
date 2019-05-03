package de.htwg.se.muehle.model

import scala.io.Source

case class Field(var filled:Array[Char] = Array.empty , val init:Boolean = false, val num_fields:Int = 24) {
  val empty_vertex = "O"
  val ZERO = 0
  val color_StoneP1 = 'b'
  val color_StoneP2 = 'w'
  val vertex_char = List(color_StoneP1, color_StoneP2, empty_vertex)
  var vertexes: Array[Char] = _
  if (init) filled = empty_grid

  def empty_grid:Array[Char] = (empty_vertex * 24).toCharArray
  /*def getAdjacencyList(v: Int): List[Int] = adjacencyList(v)

  def createEdges(source: Source): Unit = {
    for (line <- source.getLines()) {
      val node = line.split(" ")(0).toInt
      val next_Node = line.split(" ")(1).toInt

      if (node != next_Node)
        adjacencyList(node).::(next_Node)
    }
  }

  def createVertexes(): Unit = {
    for (v <- ZERO to number_vertexes)
      vertexes(v) = empty_vertex
  }

  def setVertex(vertex: Int, color: Char): Boolean = {
    if (vertex >= ZERO && vertex < number_vertexes && vertex_char.contains(color)) { vertexes(vertex) = color; true }
    else false
  }

  def getVertex(vertex: Int): Char = {
    if (vertex >= ZERO && (vertex < number_vertexes))
      vertexes(vertex)
    else empty_vertex
  }

  def init(): Unit = {
    adjacencyList = List[List[Int]]()
    vertexes = Array[Char](24)

    val file: Source = Source.fromFile("util/GridEdges.txt")
    createEdges(file)

    createVertexes()
  }
  */
  override def toString: String = {
    val row1 = "x-----x-----x\n"
    val row2 = "| x---x---x |\n"
    val row3 = "| | x-x-x | |\n"
    val mid  = "x-x-x   x-x-x\n"
    var field = row1 + row2 + row3 + mid + row3 + row2 + row1
    for {
      index <- 0 until num_fields
    } field = field.replaceFirst("x", filled(index).toString())
    field
  }
}
