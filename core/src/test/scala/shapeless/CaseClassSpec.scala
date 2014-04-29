package shapeless

import org.scalatest.FunSuite

import shapeless._
class CaseClassSpec extends FunSuite {

  test("case class copy") {

    case class Test1(a: String, b: Int, c: Char)

    case class Test2(a: String, b: Int)

    val test1 = Test1("first", 2, '3')

    val test2 = Test2("1st", 20)
//
//    val test1Gen = Generic[Test1]
//
//    val test2Gen = Generic[Test2]
//
//    val test3 = test1Gen.from(test2Gen.to(test2) :+ test1.c)
  }

}
