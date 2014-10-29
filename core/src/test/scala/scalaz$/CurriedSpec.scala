package scalaz$

import org.scalatest.FunSuite

class CurriedSpec extends FunSuite {

  test("Curried spec") {
    val result = List(1, 2, 3, 4) map {(_: Int) * (_:Int)}.curried
  }

}
