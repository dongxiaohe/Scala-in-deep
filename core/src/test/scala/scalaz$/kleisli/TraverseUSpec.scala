package scalaz$.kleisli

import core.collection.QuickSortSpec
import core.collection.QuickSortSpecTest._
import org.scalacheck.Prop._
import org.scalacheck.Properties
import scalaz._
import Scalaz._

object TraverseUSpec extends Properties("List") {

  property("spike on traverseU") = forAll { (anyList : List[Int]) =>

    def add(x: Int) = x + 1

    if (anyList.isEmpty) true
    else {

      val g = { (x: Int) => List(x, 5) }

      val expected = anyList.map(g).reduceLeft((a, b) => a ++: b)
      val actual = anyList.traverse(g)

      println(actual)

      expected == actual
    }

  }

}
