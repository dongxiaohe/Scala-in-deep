package aync

import org.scalatest.FlatSpec
import scala.util.{Failure, Success}

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


}
