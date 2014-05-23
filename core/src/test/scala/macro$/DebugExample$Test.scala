package macro$

import org.scalatest.FunSuite

class DebugExample$Test extends FunSuite {

  test("macros do stuff") {
//    case class Person(name: String, age: Int)
//    implicit val personReads = (
//      (__ \ 'name).reads[String] and
//        (__ \ 'age).reads[Int]
//      )(Person)


    val x = 43
//    "%d".format(x)
    f"$x%d"

    def doStuff(x: Int)(y: String): Boolean = true

    val result: Int => String => Boolean = doStuff

    println(result(3)("3"))

  object A {
    class B
  }

  class A{
    import A.B
    var b: B = null
  }

  val a = new A
  val b = new A.B

  val a3 = new A
  a3.b = b

  }

}
