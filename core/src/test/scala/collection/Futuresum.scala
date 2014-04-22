package collection

import scala.concurrent.{Await, future, Future}
import scala.concurrent.duration._

import scala.concurrent.ExecutionContext.Implicits.global

object futuresum extends App {

  def f1 = future { 12 }
  def f2 = future { 13 }

  val result1 = f1.flatMap(x => f2.map(y => x + y))
  println(result1.value)

  val result2 = for (x <- f1; y <- f2) yield (x + y)

  Await.result(result2, 3 seconds)

  if(result2.isCompleted)
  println(result2.value)

}