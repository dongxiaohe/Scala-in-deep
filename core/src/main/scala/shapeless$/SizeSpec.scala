package shapeless$

import org.scalatest.FunSuite
import shapeless._
import nat._
import syntax.sized._

class SizeSpec extends FunSuite {

  test("Sized") {

    def func(l: Sized[List[Int], _3]) = l

    List(1,2,3,4,5,6).grouped(3).map(_.sized(3).get).map(func)
//    List(1,2,3,4,5,6).grouped(100).map(_.sized(100).get).map(func)

  }

}
