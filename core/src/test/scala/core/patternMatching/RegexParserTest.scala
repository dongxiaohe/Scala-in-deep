package core.patternMatching

import org.scalatest.FunSuite

class RegexParserTest extends FunSuite {

  test("regex") {
    val html = """<a href="/web/content/">web content</a>"""
    val Content = "<a href=\"(.*)\".*>".r

    html match {
      case Content(c) => println(s"c=${c}")
      case _ => println("123")
    }

    List.tabulate(3)(_+1)
  }

}
