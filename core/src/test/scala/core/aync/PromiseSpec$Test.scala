package core.aync

import org.scalatest.FunSuite
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}

class PromiseSpec$Test extends FunSuite {

  test("promise is a guarantee") {
    val value = {
      Thread.sleep(1000)
      3
    }

    def doUnrelatedThing(): Unit = {
      Thread.sleep(3000)
      println("unrelated things finished")
    }

    val promiseInt = Promise[Int]()
    val promiseIntFuture = promiseInt.future

    val producer = Future {
      println("producer starting processing")

      promiseInt success value


      doUnrelatedThing()
    }

    val consumer = Future {
      println("consumer starting processing")

      promiseIntFuture.onSuccess {
        case a => println("consumer got the value : " + a)
      }
    }


    Thread.sleep(3000)

  }

}
