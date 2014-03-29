package collection

import org.scalatest.FunSuite

class ReplaceAllInSpec$Test extends FunSuite {

  test("replace string to map value based on map key") {
    val replacements = Map("hello" -> "123", "world" -> "123", "scala" -> "123")

    val value = "an example, hello world scala"

    val result: String = ReplaceAllInSpec.process(value, replacements)

    assert(result === "an example, 123 123 123")

  }
}
