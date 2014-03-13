package collection

import org.scalatest.FunSuite

class FoldLeftSpecTest extends FunSuite {

  test("use foldLeft as decorator to convert string") {

    assert(FoldLeftSpec.convert("alacs") === "SCALA Cool")
  }
}
