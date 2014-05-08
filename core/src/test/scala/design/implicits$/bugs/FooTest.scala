package design.implicits$.bugs

import org.scalatest.FunSuite

class FooTest extends FunSuite {
  trait Bar {
    def doSomething : String
    override def toString = "Foo(" + ").Bar -> " + doSomething
  }
  object Bar {
    implicit def fromFunction(func : Function0[String]) = new Bar {
      def doSomething = func()
    }
  }
  test("foo") {
    trait Foo {
      val name : String

      def andThen(b : Bar) = b
    }

//    trait Bar {
//      def doSomething : String
//      override def toString = "Foo(" + ").Bar -> " + doSomething
//    }
//    object Bar {
//      implicit def fromFunction(func : Function0[String]) = new Bar {
//        def doSomething = func()
//      }
//    }

    object Foo {
      def foo(n : String) = new Foo {
        override val name = n
      }
    }

    println(Foo.foo("foo") andThen(() => "Bar"))

  }

}
