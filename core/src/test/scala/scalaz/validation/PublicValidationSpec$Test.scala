package scalaz.validation

import org.scalatest.FunSuite

import scalaz._
import Scalaz._

class PublicValidationSpec$Test extends FunSuite {

  test("should accept valid user info") {
    val validate: Validation[String, String] = PublicValidationSpec.validate(User("danny", true, 27))

    println(validate)
//    validate === "Congrats, danny"
  }

  test("should immediately return the error message if any condition fails") {

    println(PublicValidationSpec.checkName(User("", true, 27)))
  }

  test("should return all errors") {

//    def subseqs[A](n: Int)(iter: Iterator[A]) = {
//      val i = iter.toStream
//      1 to n flatMap i.sliding
//    }
//
//    println((subseqs(3)(List(1,2,3,4).iterator)))

//    println(PublicValidationSpec.validateAll(User("", false, 0)))
  }


  test("simple scalaz validation") {

    def isThree(x: Int): Validation[NonEmptyList[String], Int] = if (x!= 3){("failed: %d" format x).wrapNel.failure} else {x.success}

    println(isThree(4))
    println(isThree(3))

    val number = Seq(isThree(13), isThree(15))
    val result = number.reduceLeft(_ <* _)
    println(result)
    println((isThree(6) |@| isThree(7) |@| isThree(13) ) {_ + _ + _})

  }

  test("catch validation") {
    import scala.util.control.Exception._

    val x: Seq[String] = Seq("123")
    def get(position: Int): Validation[String, String] = {
      catching(classOf[IndexOutOfBoundsException]) either {
        x(position)
      } match {
        case Left(e: IndexOutOfBoundsException) => "arg is missing".fail
        case Right(i) => i.success
        case _ => "something wrong".fail
      }
    }

    val result = (get(3) |@| get(4)) {_ + _}

    println(result)
  }

}
