package function

import org.scalatest.FunSuite

class FunctionSpecTest extends FunSuite {

  test("Function object can tuple method") {
    def showIntAndString(x: Int, y: String): String = x + ", " + y

    val tupled = Function tupled showIntAndString _

    assert(tupled((123, "123")).toString === "123, 123")

  }

}
