package core.function

import org.scalatest.FunSuite

class PartialFunctionSpec extends FunSuite {



  test("partial function spec") {


    class Foo

    class Bar extends Foo

    type FooResult = PartialFunction[Foo, String]


    val fooHandler: FooResult = {
      case x: Foo => "foo"
    }

    val barHandler: FooResult = {
      case x: Bar => "bar"
    }

    val result = barHandler.orElse(fooHandler)(new Foo)


    println(result)

    def doStuffWithFunc(x: () => String) = {
      x()
    }

    def doStuff(x: => String) = {
      x
    }

    def show(): String = "3"

    doStuffWithFunc(show)
    doStuff(show())


  }
}
