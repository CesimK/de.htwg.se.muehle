package de.htwg.se.muehle.model

import org.scalatest._

@Ignore
class PlayerSpec extends WordSpec with Matchers {
  "A Player" when { "new" should {
    val player = Player("Your Name")
    "have a name"  in {
      player.name should be("Your Name")
    }
    "have a nice String representation" in {
      player.toString should be("Your Name")
    }
    "Also the player should have the start amount of 9 stone" in {
      player.stones shuld be("9")
    }
    "With all these stones the player is not be able to jump with his stones" in {
      player.jump should be(false)
    }
  }}
}
