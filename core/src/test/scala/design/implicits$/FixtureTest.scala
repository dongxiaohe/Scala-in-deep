package design.implicits$

import org.scalatest.{Matchers, Inspectors, Outcome, fixture}

class FixtureTest extends fixture.FunSuite with Matchers {

  case class FixtureParam(x: String) {
    val getStuff: String = {
      println("get stuff .............")
      x
    }
  }

  override def withFixture(test: OneArgTest): Outcome = {
    try {
      println("starting")

      withFixture(test.toNoArgTest(FixtureParam("123")))
    } finally {

      println("done")
    }
  }

  test("do stuff") {t =>

    t. getStuff
    println("processing do stuff")
  }

  test("123") {t =>

    t. getStuff
    println("processing 123")
    import Inspectors._

    forAll(List(1,2,3))(x => x > 0)
  }

  test("throw exception") {t =>

    t. getStuff
    throw new NullPointerException
  }


}
