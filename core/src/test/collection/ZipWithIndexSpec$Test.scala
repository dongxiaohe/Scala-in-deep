package collection

import org.scalatest.FunSuite

class ZipWithIndexSpec$Test extends FunSuite {

  test("ZipWithIndex can pick up specified elements to op") {

    val col = Seq("a", "b", "c", "d", "e", "f", "g")
    val positionColNeedTobeExtracted = Seq(3, 4)

    val result: Seq[String] = ZipWithIndexSpec.perform(col)(_.toUpperCase, positionColNeedTobeExtracted)

    assert(result === Seq("a", "b", "C", "D", "e", "f", "g"))

  }

}
