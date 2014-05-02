package shapeless$

import org.scalatest.FunSuite
import scalaz.syntax

class IdentitySpec extends FunSuite {

  test("use identity") {
    import shapeless._
    import syntax.std.tuple._

    val list = List((1, "a"), Tuple1('c'))

//    val result = ((1, "a"), (3, "c")).flatMap(identity)
//
//    assert(result === List(1, "a", 3, "3"))
  }
}
