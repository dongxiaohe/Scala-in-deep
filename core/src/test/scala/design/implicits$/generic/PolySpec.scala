package design.implicits$.generic

import org.scalatest.FunSuite
import shapeless.Poly1

class PolySpec extends FunSuite {

  test("implicit for the generic") {

    object inc extends Poly1 {
      implicit val caseInt = at[Int]{_ + 1}
      implicit def default[T] = at[T](identity)
    }

    println(List(3).map(inc))
    println(List("3").map(inc))

  }
}
