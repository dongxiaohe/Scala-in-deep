package scalaz$.collection

import org.scalatest.FunSuite

import scala.util.Random

class CollectionSpec extends FunSuite {

  test("bind operation") {

    import scalaz._
    import Scalaz._
    import scalaz.Bind._

//    val result = List(1,2,3,4) >>= bind
//
//    println(result)


    case class Staff(name: String, numberOfTasks: Int)

    implicit val staffListMonoid = new Monoid[List[Staff]] {

      override def zero: List[Staff] = Nil

      override def append(f1: List[Staff], f2: => List[Staff]): List[Staff] = {

        val f1Map = f1.map(t => (t.name, t.numberOfTasks)).toMap
        val f2Map = f2.map(t => (t.name, t.numberOfTasks)).toMap

        val f3Map = f2Map |+| f1Map

        f3Map.map(t => Staff(t._1, t._2)).toList
      }
    }

    val list1 = List(Staff("danny", 1), Staff("John", 2), Staff("Jacob", 7))
    val list2 = List(Staff("danny", 3), Staff("John", 3), Staff("Nick", 3))
    val list3 = List(Staff("boss", 3))

    val result = List(list1, list2, list3).reduceLeft(_ |+| _)


    case class Test(dayOfWeek:Int,b:Int=Random.nextInt)
    val data=(3 to 36).map(_ % 7).map(Test(_))
    val (firstWeek, nextWeeks) = data.span(_.dayOfWeek != 0)
    val weeks = (firstWeek :: nextWeeks.grouped(7).toList).dropWhile(_.isEmpty)
    val weeksWithoutEmpty = (firstWeek :: nextWeeks.grouped(7).toList).dropWhile(_.isEmpty)

    assert(weeks == weeksWithoutEmpty)


  }

}
