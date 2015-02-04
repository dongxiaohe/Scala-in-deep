package scalaz$

import org.scalatest.FunSuite

import scalaz._
import Scalaz._

class SumSpec extends FunSuite {

  test("sum") {
    val list = List(
      Map("id" -> "A", "value" -> 20, "name" -> "a"),
      Map("id" -> "B", "value" -> 10, "name" -> "b"),
      Map("id" -> "A", "value" -> 5, "name" -> "a"),
      Map("id" -> "C", "value" -> 1, "name" -> "c"),
      Map("id" -> "D", "value" -> 60, "name" -> "d"),
      Map("id" -> "C", "value" -> 3, "name" -> "c")
    )

    val result = list.map{m =>
      Map(m("id").asInstanceOf[String] → m("value").asInstanceOf[Int])
    }.suml

    println(result)

  }

}
