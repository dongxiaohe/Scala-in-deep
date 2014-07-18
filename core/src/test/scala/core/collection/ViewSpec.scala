package core.collection

import org.scalatest.FunSuite

class ViewSpec extends FunSuite {

  test("view spec") {
    println((1 to 1000000000).view.map(identity).filter(_%3==0).take(1).toList)

    //    List(element, element, element).view.map(x => x).find(x => x == 3)

  }

}
