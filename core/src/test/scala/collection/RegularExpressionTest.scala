package collection

import org.scalatest.FunSuite

class RegularExpressionTest extends FunSuite {

  test("split by , and take single quote as one part") {
    val s = "foo,bar, 'this,is foo'"
    val ptn = "(('[^']*')|([^,]+))".r
    val theMatches = ptn.findAllMatchIn(s).toList

//    assert(theMatches.last.toString() == "'this,is foo'")
  }

}
