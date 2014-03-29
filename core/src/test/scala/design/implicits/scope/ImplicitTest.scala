package design.implicits.scope

import org.scalatest.{FlatSpec, FunSuite}

class ImplicitTest extends FlatSpec {

  "implicit class" should "enrich current class ability" in {

    class Foo

    implicit class Add(foo : Foo) {
      def doStuff = "hello world"
    }

    assert(new Foo().doStuff === "hello world")

  }

}
