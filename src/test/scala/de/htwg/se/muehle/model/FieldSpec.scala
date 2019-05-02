package de.htwg.se.muehle.model

import org.scalatest.{Matchers, WordSpec}

class FieldSpec extends WordSpec with Matchers {
  "A Field" when {
    "new" should {
      val adjacencyList = Field()
      "have a adjacencyList" in {
        adjacencyList.getAdjacencyList should be(adjacencyList(List[Int]))
      }
      "creating Edges" in {
        adjacencyList.createEdges should be(adjacencyList(List))
      }
      "Create Vertexes" in {
        adjacencyList.createVertexe should be(Unit)
      }
      "Set a Stone in Vertex" in {
        adjacencyList.setVertex should be(true)
      }
      "Get Stone position" in {
        adjacencyList.getVertex should be(vertex0)
      }
    }
  }
}
