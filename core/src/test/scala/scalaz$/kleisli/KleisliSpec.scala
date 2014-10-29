package scalaz$.kleisli

import org.scalatest.FunSuite
import scalaz._
import Scalaz._


class KleisliSpec extends FunSuite {

  test("kleisli example") {
    type StringPair = (String, String)

    val f: Int => List[String] = i => List((i |+| 3).toString, (i |+| 4).toString)
    val g: String => List[StringPair] = t => List("C" -> t, t -> "D")

    val k = Kleisli(f) >=> Kleisli(g)

    println(k(3))

    val l = List(List(1,2,3), List(4,5,6)).transpose

    println(l)

    def print(x: Int) = {
      println("processing")
      println(x)
      x.toString
    }

    def sum(x: Int) = x + 1

    List(1,2,3).traverseU(print)
//    List(1,2,3).traverseM(print)

    println(30.0 ?|? 3.0)
  }

}
