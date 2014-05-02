package design.linearization

import org.scalatest.FunSuite
import TraitAbstractValSpec.Foo

class TraitAbstractValSpec$Test extends FunSuite {

  test("should return null instead of name") {

    val foo = new Foo {
      override val name: String = "name"
    }

    assert(foo.toString === null)
  }

  test("should get name value by using lazy") {

    val foo = new Foo {
      override lazy val name: String = "name"
    }

    assert(foo.toString === "name")
  }

  test("should get name value by anonymous class") {

    class Bar extends {val name = "name"} with Foo
    val bar = new Bar

    assert(bar.toString === "name")
  }

}
