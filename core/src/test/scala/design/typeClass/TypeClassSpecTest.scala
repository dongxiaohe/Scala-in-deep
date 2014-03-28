package design.typeClass

import org.scalatest.FunSuite
import scala.util.{Failure, Success, Try}

class TypeClassSpecTest extends FunSuite {

  test("type class example") {

    implicit val directShow = new Show[Int] {
      override def show (x : Int) = x
    }

    TypeClassSpec.process(3) === 3

    TypeClassSpec.unaryProcess(3) === "|||"

  }

}
