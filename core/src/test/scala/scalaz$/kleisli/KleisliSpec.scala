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

    println(List(1,2,3).traverseU(sum))

    List(1,2,3).traverseU(print)
//    List(1,2,3).traverseM(print)

    println(30.0 ?|? 3.0)
  }

  test("whatever") {
//    def str(x: Int): Option[String] = Some(x.toString)
//    def toInt(x: String): List[Int] = List(x.toInt)
//    def double(x: Int): Option[Double] = Some(x * 3)
//
//    val result = Kleisli(str _) >=> Kleisli(toInt _) >=> Kleisli(double _)
//
//    println(result(3))

     println(List(12,14,16,18,20,22,28,30).sliding(2).toList)

  }

}
