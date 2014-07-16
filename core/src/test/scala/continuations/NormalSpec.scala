package continuations

import org.scalatest.FunSuite
import scala.util.continuations._

class LongConsumer {
  def consume(l: Long) = Unit
}

case class X(x: Long)

object X {
  implicit class ConsumeX(val c: LongConsumer) extends AnyVal {
    def consume(x: X) = c consume x.x
  }
  implicit class EatX(val c: LongConsumer) extends AnyVal {
    def eat(x: X) = c consume x.x
  }
}

class NormalSpec extends FunSuite {


  test("shift example") {

    type IntToUnit = Int => Unit

    def printInt: IntToUnit = {intValue => {
      println(intValue)
    }}

    def foo(x: Int)(callback: Int => String) = {
      Thread.sleep(3000)//represent time consuming operation

      callback(x)
      println("end of method")
      ""
    }

    def bar(x: Int)(callback: Int => String) = {
      Thread.sleep(13000)//represent time consuming operation

      callback(x)
      println("end of method")
      ""
    }


    reset {

      println("start....")
      def t = shift(bar(3))
      println("continue executing..............")

      def r = shift(foo(4))
      println("continue executing..............")

      println(t)
      println(r)

      ""

    }

    object Tryout {
      // A: does not need import to compile - why?
      new LongConsumer().consume(X(10L))

      // B: needs import to compile - why?
      import X.EatX
      new LongConsumer().eat(X(10L))
    }

  }




}
