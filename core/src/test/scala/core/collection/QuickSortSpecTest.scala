package core.collection

import org.scalacheck.{Prop, Properties}
import Prop.forAll

object QuickSortSpecTest extends Properties("List") {

  property("binary search should order list") = forAll { (anyList : List[Int]) =>
    QuickSortSpec.sort(anyList) == anyList.sorted
  }
}
