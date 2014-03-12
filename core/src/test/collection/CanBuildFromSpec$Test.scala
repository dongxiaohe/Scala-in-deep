package collection

import org.scalatest.FunSuite

class CanBuildFromSpec$Test extends FunSuite {

  test("combine the values with generic collection type") {
    val seq = Seq(("1", "3"), ("3", "123"), ("3", "123"))

    CanBuildFromSpec.combineValues[String, List](seq) === Seq(("1", List("1")), ("3", List("123", "123")))

    CanBuildFromSpec.combineValues[String, Seq](seq) === Seq(("1", Seq("1")), ("3", Seq("123", "123")))

    CanBuildFromSpec.combineValues[String, Array](seq) === Seq(("1", Array("1")), ("3", Array("123", "123")))

  }

}
