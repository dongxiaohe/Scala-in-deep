package design.implicitScope

import org.scalatest.FunSuite

class Foo$Test extends FunSuite {

  test("should limit implicit scope") {
     Foo.isValid === true
  }

}
