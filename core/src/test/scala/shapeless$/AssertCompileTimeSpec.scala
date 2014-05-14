package shapeless$

import org.scalatest.FunSuite

class AssertCompileTimeSpec extends FunSuite {

  test("assert stuff in compile time") {
    def assertNoInstanceOf[T](implicit instance: T = null) = assert(instance == null)


  }

}
