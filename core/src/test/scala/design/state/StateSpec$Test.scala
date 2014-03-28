package design.state

import org.scalatest.FlatSpec
import scala.util.{Failure, Try}

class StateSpec$Test extends FlatSpec {

  import StateSpec._

  "child State" should "not read the book" in {

    val person = new Person

    val result : Try[String] = person.read()

    assert(result.isInstanceOf[Failure[String]] === true)

  }

  "young State" should "not read the book" in {

    val person = new Person
    person.state = young

    val result : Try[String] = person.read()

    assert(result.get === "young people read book")

  }

  "elder State" should "not read the book" in {

    val person = new Person
    person.state = elder

    val result : Try[String] = person.read()

    assert(result.get === "elder people read book")

  }

}
