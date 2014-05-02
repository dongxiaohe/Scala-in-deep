package design.kind

import org.scalatest.FunSuite

class HOMap$Test extends FunSuite {

  test("handle Option List") {
    val map: HOMap[Option, List] = HOMap[Option, List](
      Some("foo") -> List("foo", "bar", "baz"),
      Some(true) -> List(true, false, true, true),
      Some(43) -> List(1, 2, 3)
    )
    val result: List[Int] = map(Some(43))

    assert(result === List(1, 2, 3))
  }

}
