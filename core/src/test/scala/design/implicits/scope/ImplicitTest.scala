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

  "implicit argument with manifest" should "enrich class behaviour" in {

    def foo[T](x: List[T])(implicit m: Manifest[T]) = {
      if (m <:< manifest[String])
        println("Hey, this list is full of strings")
      else
        println("Non-stringy list")
    }

    foo(List("123"))

  }

}