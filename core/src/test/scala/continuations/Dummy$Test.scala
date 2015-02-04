package continuations

import org.scalatest.{Matchers, FunSuite}

class Dummy$Test extends FunSuite with Matchers {

  test("should sort element") {
    val list = List(1,7,2,3)

    Dummy.sort(list) should be (Seq(1,2,3,7))

  }

}
