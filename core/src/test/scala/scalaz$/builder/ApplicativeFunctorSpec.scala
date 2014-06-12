package scalaz$.builder

import org.scalatest.FunSuite
import scalaz._
import Scalaz._


class ApplicativeFunctorSpec extends FunSuite  {


  test("applicative functor") {

    val map1 = Map(1 -> List(3) , 2 -> List(30))
    val map2 = Map(1 -> List(100), 3 -> List(300))
    val map3 = map1 |+| map2

    println(map3)

  }

}
