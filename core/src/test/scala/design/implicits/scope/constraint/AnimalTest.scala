package design.implicits.scope.constraint

import org.scalatest.FunSuite

class AnimalTest extends FunSuite {

  test("Apple can not fish") {
    class People extends Animal[Fruit]

//    new People().fish
  }

  test("Bear can fish") {
    class Bear extends Animal[Fish]

    assert(new Bear().fish === "I got a fish")
  }

}
