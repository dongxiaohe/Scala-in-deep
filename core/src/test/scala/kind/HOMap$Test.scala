package kind

import org.scalatest.FunSuite

class HOMap$Test extends FunSuite {

  test("handle Option List") {
    val map: HOMap[Option, List] = HOMap[Option, List](
      Some("foo") -> List("foo", "bar", "baz"),
      Some(43) -> List(1, 1, 2, 3),
      Some(true) -> List(true, false, true, true))
    val result: List[String] = map(Some("43"))


  }

}
