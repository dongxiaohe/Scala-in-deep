package continuations

import org.scalatest.FunSuite
import scala.util.continuations._

class NormalSpec extends FunSuite {


  test("shift example") {

    type IntToUnit = Int => Unit

    def printInt: IntToUnit = {intValue => {
      println(intValue)
    }}

    def foo(x: Int)(callback: Int => Unit) = {
      Thread.sleep(3000)//represent time consuming operation

      callback(x)
      println("end of method")
    }

    def bar(x: Int)(callback: Int => Unit) = {
      Thread.sleep(13000)//represent time consuming operation

      callback(x)
      println("end of method")
    }


    reset {

      println("start....")
      def t = shift(bar(3))
      println("continue executing..............")

      def r = shift(foo(4))
      println("continue executing..............")

      println(t)
      println(r)

    }


  }


}
