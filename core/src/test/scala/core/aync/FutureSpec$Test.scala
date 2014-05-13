package core.aync

import org.scalatest.FlatSpec
import scala.util.{Failure, Success}
import scala.concurrent._
import scala.util.Success
import scala.util.Failure
import scala.util.Success
import scala.util.Failure

class FutureSpec$Test extends FlatSpec {

  "future" should "be a functor" in {

    import concurrent._
    import concurrent.ExecutionContext.Implicits.global

    def doStuff1(x: Int) : Int = x + 3

    def doStuff2(x : Int) : Int = x * 3

    def doStuff3(x : Int) : String = {3.toString}

    lazy val chain = future{doStuff1(0)} map doStuff2 map doStuff3

    var result : String = ""

    chain onComplete {
      case Success(x) => result = x; assert(result === "3")
      case Failure(_) => throw new IllegalArgumentException
    }

  }

  "future" should "start a thread to calculate a number" in {

    import scala.concurrent.{Await, future, Future}
    import scala.concurrent.duration._
    import concurrent.ExecutionContext.Implicits.global

    def f1 = future { 12 }
    def f2 = future { 13 }

    val result1 = f1.flatMap(x => f2.map(y => x + y))
    println(result1.value)

    val result2 = for (x <- f1; y <- f2) yield (x + y)

    Await.result(result2, 3 seconds)

    if(result2.isCompleted)
      println(result2.value)
  }

  "future" should "success biased" in {

    import scala.concurrent.ExecutionContext.Implicits.global
    val firstError = Future{"abc".toInt}
    val secondError = Future{null.getClass; 3}

    Thread.sleep(3000)

    firstError.flatMap(_ => secondError).onComplete {
      case Failure(ex) => println(ex)
      case a => "success"
    }

    val firstSuccess = Future{"123".toInt}
    val secondSuccess = Future{3}

    firstSuccess.flatMap(_ => secondSuccess).onComplete {
      case Failure(ex) => ex.getMessage
      case a => println("success")
    }
  }

}
