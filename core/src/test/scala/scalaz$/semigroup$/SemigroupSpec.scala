package scalaz$.semigroup$

import org.scalatest.FunSuite
import scalaz._
import Scalaz._

class SemigroupSpec extends FunSuite {


  case class Staff(name: String, numberOfTasks: Int)

  test("semi group for the List") {

    val result1 = List(Staff("John", 36), Staff("Andrew", 30))
    val result2 = List(Staff("John", 40), Staff("Danny", 30))
    val result3 = List(Staff("Andrew", 30))
    val result4: List[Staff] = List()

    implicit val staffListSemigroup: Monoid[List[Staff]] = new Monoid[List[Staff]] {

      override def zero: List[Staff] = Nil

      override def append(f1: List[Staff], f2: => List[Staff]): List[Staff] = {

        val mapSemigroup = f1.map(t => (t.name, t.numberOfTasks)).toMap |+| f2.map(t => (t.name, t.numberOfTasks)).toMap

        mapSemigroup.map(t => Staff(t._1, t._2)).toList

      }
    }

    val result = List(result1, result2, result3, result4).reduceLeft(_ |+| _)

    assert(result.size == 3)
  }
}
