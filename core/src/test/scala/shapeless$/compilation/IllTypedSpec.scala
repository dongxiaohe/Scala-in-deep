package shapeless$.compilation

import org.scalatest.FunSuite

class IllTypedSpec extends FunSuite {

  test("illTyped can check logic ") {
    def foo(s: Int) = s

    import shapeless.test.illTyped

//    illTyped("""foo(123)""")
    illTyped("""foo("hello")""")
  }

}
