package collection

import org.scalatest.FunSuite

class CanBuildFromSpec$Test extends FunSuite {

  test("combine the values with generic collection type") {
    val seq = Seq(("1", "3"), ("3", "123"), ("3", "123"))

    assert(CanBuildFromSpec.combineValues[String, List](seq) === Seq(("1", List("3")), ("3", List("123", "123"))))

    assert(CanBuildFromSpec.combineValues[String, Seq](seq) === Seq(("1", Seq("3")), ("3", Seq("123", "123"))))

    assert(CanBuildFromSpec.combineValues[String, Set](seq) === Seq(("1", Set("3")), ("3", Set("123"))))

  }

}
