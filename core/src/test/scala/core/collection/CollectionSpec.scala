package core.collection

import org.scalatest.FunSuite

class CollectionSpec extends FunSuite {

  test("collection diff") {

    val list = List(1,2,3,4)
    println(list.diff(List(4)))
    println(list)


  }

}
