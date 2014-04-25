package scalaz.builder

import org.scalatest.FunSuite


class ApplicativeBuilderSpec$Test extends FunSuite {

  test("Option[function] can combine with Option[T]") {

    val optionFunction = Option[Int => Int]{x: (Int) => x + 4}
    val optionValue = Option[Int](3)

    val optionResult = ApplicativeBuilderSpec.handle(optionFunction, optionValue)

    assert(optionResult.get === 7)

  }

  test("can add values") {

    val result = ApplicativeBuilderSpec.handle("1", "2", "3")

    assert(result.get === 6)
  }

  test("should return None instead of throw NullPointerException") {

    val result = ApplicativeBuilderSpec.handle("3", "4", null.asInstanceOf[String])

    assert(result === None)
  }

  test("|+|") {
    import scalaz._
    import Scalaz._
    val result = List(1,2,3) |+| List(4,5,6)

    assert(result == List(1,2,3,4,5,6))
  }

  test("option") {
    import scalaz._
    import Scalaz._

    val result = Some(3).map(_ + 1) getOrElse( 7 )

    val scalazResult = Some(3) some(_ + 1) none(7)

    assert(~(Some(3)) == 3)
    assert(result == scalazResult)
  }
}
