//package de.htwg.se.muehle.controller
//
//import com.sun.org.apache.xpath.internal.operations.And
//import de.htwg.se.muehle.controller.controllerComponent.controllerBaseImpl.{Controller, ControllerStateStatus}
//import de.htwg.se.muehle.model.gridComponent.gridBaseImpl.Grid
//import de.htwg.se.muehle.model.playerComponent.Player
//import org.scalatest.{Matchers, WordSpec}
//
//class ControllerStateStatusSpec extends  WordSpec with Matchers with ControllerStateStatus {
//  "A State" when { "new" should {
//    val x = new ControllerStateStatus() {
//      override def selectedFieldNotReachable(controller: Controller): Unit = ???
//
//      override def allStonesPlaced(controller: Controller): Unit = ???
//
//      override def slotIsFilled(controller: Controller): Unit = ???
//
//      override def stonesStillAvailable(controller: Controller): Unit = ???
//
//      override def selectedFieldInvalid(controller: Controller): Unit = ???
//
//      override def selectedFieldNotEmpty(controller: Controller): Unit = ???
//    }
//    val grid = Grid(init = true)
//    val player1 = Player("Person 1", 'W')
//    val player2 = Player("Person 2", 'B')
//    val controller = new Controller(grid, player1, player2)
//    "setStatePlaceStones" in {
//      x.setStatePlaceStones(controller: Controller) should be(allStonesPlaced(controller) And )
//    }
//    "setStateMoveStones" in {
//      x.setStateMoveStones(controller: Controller) should be(Unit)
//    }
//  }}
//
//  override def selectedFieldNotReachable(controller: Controller): Unit = ???
//
//  override def allStonesPlaced(controller: Controller): Unit = ???
//
//  override def slotIsFilled(controller: Controller): Unit = ???
//
//  override def stonesStillAvailable(controller: Controller): Unit = ???
//
//  override def selectedFieldInvalid(controller: Controller): Unit = ???
//
//  override def selectedFieldNotEmpty(controller: Controller): Unit = ???
//}
