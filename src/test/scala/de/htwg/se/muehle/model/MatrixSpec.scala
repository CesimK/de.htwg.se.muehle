package de.htwg.se.muehle.model

import org.scalatest._

class MatrixSpec extends WordSpec with Matchers {
  "A Matrix" when { "new" should {
    val vector = Vector[Cell](Cell())
    val matrix = Matrix[Cell](Vector[Vector[T]](vector))
    "produce a grid size with 1 times 1" in {
      matrix.size should be (1)
      matrix.rows should be (1)
      matrix.cols should be (1)
    }
  }}
}
