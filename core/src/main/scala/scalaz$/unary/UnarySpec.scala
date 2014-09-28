package scalaz$.unary
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object UnarySpec {

  def main(args: Array[String]) {
    import scalaz._ ; import Scalaz._

    val List(a,b,c,d) = List(Some("str1"), Some("str2"),None,Some("str3"))

    val result = ~a + ~b + ~c + ~d

    println(result)



    val futures = for (t <- 1 to 4) yield Future { Thread.sleep(3000);t }
    val resultFuture = Future.firstCompletedOf(futures)

    resultFuture.onComplete(t => println(t.get))

    println(123)

    Thread.sleep(3000)
  }

}