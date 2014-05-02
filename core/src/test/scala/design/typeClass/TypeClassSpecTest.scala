package design.typeClass

import org.scalatest.FunSuite
import scala.util.{Failure, Success, Try}

class TypeClassSpecTest extends FunSuite {

  test("type class example") {

    implicit val intShow = new Show[Int] {
      override def show(x : Int) = x + 3
    }

    TypeClassSpec.process(3) === 3

    TypeClassSpec.unaryProcess(3) === "|||"

  }

}
