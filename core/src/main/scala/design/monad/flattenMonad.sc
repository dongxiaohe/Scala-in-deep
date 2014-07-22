import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
val result = Future(List(Future(1),Future(2),Future(3)))
result map(Future.sequence(_))

List(1,2,3).span(_ > 1)
List(1,2,3).partition(_ > 1)
