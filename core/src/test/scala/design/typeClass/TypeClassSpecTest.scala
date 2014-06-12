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

  test("constraint") {
    trait Common

    case object HouseWork extends Common
    case object Food extends Common

    class Animal[T <: Common] {

      def doHouseWork(implicit x: T <:< HouseWork.type): Unit = {
        println("do house work")
      }

    }

    val people = new Animal[HouseWork.type]
    val dog = new Animal[Food.type]

    people.doHouseWork

//    dog.doHouseWork


  }

}
