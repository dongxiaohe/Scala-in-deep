package scalaz$

import org.scalatest.FunSuite

class FProductSpec extends FunSuite {

  test("fproduct") {
    import scalaz._
    import Scalaz._

    val collection = List(1, 2, 3)

    println(collection.fproduct(_.toString))
  }

}
