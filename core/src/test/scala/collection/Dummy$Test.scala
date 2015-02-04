package collection

import org.scalatest.{Matchers, FunSuite}

class Dummy$Test extends FunSuite with Matchers {

  test("should do stuff") {

    Dummy.doStuff() should be ("123")

  }

}
