package collection

import org.scalacheck.{Prop, Properties}
import Prop.forAll

object QuickSortSpecTest extends Properties("List") {

  property("quick sort should order list") = forAll { (anyList : List[Int]) =>

//    println(QuickSortSpec.sort(anyList))
//    println(anyList.sorted)
    val result = QuickSortSpec.sort(anyList).sameElements(anyList.sorted)
    if (!result) {
          println(QuickSortSpec.sort(anyList))
          println(anyList.sorted)
    } else {
      result
    }
    result
  }
}
