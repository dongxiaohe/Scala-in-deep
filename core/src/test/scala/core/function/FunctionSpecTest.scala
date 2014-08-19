package core.function

import org.mockito.ArgumentCaptor
import org.scalatest.FunSuite

class FunctionSpecTest extends FunSuite {

  test("Function object can tuple method") {
    def showIntAndString(x: Int, y: String): String = x + ", " + y

    val tupledByFunction = Function tupled showIntAndString _
    val tupled = showIntAndString _

    assert(tupledByFunction(123, "123").toString === "123, 123")
//    println(tupledByFunction === tupled)


    val map = Map("123" -> "123", "3" -> "123")

    val result = map map Function.tupled(_ -> _.length)

    val curried = (showIntAndString _).curried

    println(curried(123)("123"))

  }


  test("default function") {

    class Query {
      def getNumber = 3
    }

    class Service {

      def doStuff(x: Query) = {
        println(123)
      }

    }


    import org.mockito.Mock._
    import org.mockito.Mockito.when
    import org.mockito.Mockito.mock
    import org.mockito.Mockito.doNothing
    def doSomethingGreat[T](x: => Any = {}, captor: ArgumentCaptor[T]) {




        doNothing().when(mock(classOf[Service])).doStuff(captor.capture().asInstanceOf[Query])

      val value = captor.getValue

      println(value)

    }
    val captor = ArgumentCaptor.forClass(classOf[Query])

    doSomethingGreat(captor = captor)
    new Service().doStuff(new Query)

  }

}
