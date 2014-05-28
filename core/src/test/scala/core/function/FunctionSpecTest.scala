package core.function

import org.scalatest.FunSuite

class FunctionSpecTest extends FunSuite {

  test("Function object can tuple method") {
    def showIntAndString(x: Int, y: String): String = x + ", " + y

    val tupledByFunction = Function tupled showIntAndString _
    val tupled = showIntAndString _

    assert(tupledByFunction(123, "123").toString === "123, 123")
//    println(tupledByFunction === tupled)


    val map = Map("123" -> "123", "3" -> "123")

    val result = map map Function.tupled(_ -> _.length)

    val curried = (showIntAndString _).curried

    println(curried(123)("123"))

  }

}
