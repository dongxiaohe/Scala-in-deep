package scalaz.validation

import org.scalatest.FunSuite

import scalaz._

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
}
