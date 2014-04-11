package design.monad

import org.scalatest.FunSuite

class LinkSpec$Test extends FunSuite {

  test("chain function together without considering intermediate result") {
    val showString = () => "3"
    val showInt = () => 3

    implicit def addAndThen[A](func : () => A) = new {
      def andThen[B](that: () => B) = {
        func()
        that()
      }
    }

    assert(showInt.andThen(showString) === "3")
  }

  test("wrap any function into a context") {
    class Context[A](func: () => A) {

      def andThen[C](that : () => Context[C]) = {
        func()
        that()()
      }

      def apply() = func()

    }

    def showInt = 3
    def showString = new Context(() => "3")

    implicit def chainContext[A](x : A) : Context[A] = new Context[A](() => x)

    assert(showInt.andThen(() => showString) === "3")
  }

  test("reduce side effect") {

    val arg1: Option[String] = Option(null)
    val arg2: Option[String] = Option(null)
    val arg3: Option[String] = Option(null)

    assert(Some("123").flatMap(x => arg2).flatMap(x => arg3) === None)
    assert(arg1.flatMap(x => Option(null)).flatMap(x => arg3) === None)
    assert(Some("123").flatMap(x => Some("123")).flatMap(x => arg3) === None)
  }


}
