package shapeless$.generic

import org.scalatest.FunSuite

import shapeless._
class GenericSpec extends FunSuite {

  test("Generic in shapeless") {


    def intToString(x: Int) = x + "   "
    def intToDouble(x: Int) = x * 10d
    val fns = intToString _ :: intToDouble _ :: HNil

    val res = fns.zipApply(1 :: 3 ::HNil)

    println(res)

  }

}
