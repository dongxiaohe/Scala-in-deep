package scalaz$.typeSafe

import org.scalatest.FunSuite

import scalaz.Scalaz._
import scalaz._

class BasicSpec extends FunSuite {

  test("scalaz make === type safe") {


//    val versionToYear = Map(
//        "1.0" -> "2003", "2.0" -> "2007", "3.0" -> "2013"
//      )
//
//      //can not compile
//      def isVersionFromYear(version: String, year: String) = {
//        versionToYear get version exists (_ === year)
//      }
    case class Container(x: Int)


    implicit val reconciliationResultMonoid = new Monoid[Container] {
      override def zero: Container = Container(0)
      override def append(f1: Container, f2: => Container): Container =
      Container(f1.x + f2.x)
    }



    println(Container(3) |+| Container(4))
  }
}
