package design.typeClass

import org.scalatest.FunSuite

class TypeClassSpecTest extends FunSuite {

  test("type class example") {

    implicit val directShow = new Show[Int] {
      override def show(x: Int) = 3
    }

    TypeClassSpec.process(3) === 3

    TypeClassSpec.unaryProcess(3) === "|||"
  }

}
