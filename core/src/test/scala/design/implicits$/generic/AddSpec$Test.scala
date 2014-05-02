package design.implicits$.generic

import org.scalatest.FunSuite

class AddSpec$Test extends FunSuite {

  test("generic add method") {
    AddSpec.add("hello", "world") === "hello world"
    AddSpec.add(3, 4) === 7
  }

}
