package de.htwg.se.muehle.model

import org.scalatest.{Matchers, WordSpec}

class MillSpec extends WordSpec with Matchers {
  "A Mill" when { "new" should {
    val mill = Mill()
    "get mills" in {
     mill.mills should be(List())
    }
   }
  }
}