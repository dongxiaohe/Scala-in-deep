package design.linearization

import org.scalatest.FunSuite

class SimpleContainerTest extends FunSuite {

  test("simple container") {
    new SimpleContainer with OnlyNumbers {
      def value = 15
    }

    new SimpleContainer with OnlyString {
      def value = "15"
    }

  }

}
