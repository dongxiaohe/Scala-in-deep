package design.implicits.scope

import org.scalatest.FunSuite

class GenericAddSpec$Test extends FunSuite {

  test("generic add method") {
    GenericAddSpec.add("hello", "world") === "hello world"
    GenericAddSpec.add(3, 4) === 7
  }

}
