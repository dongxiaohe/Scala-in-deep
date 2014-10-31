package scalaz$

import org.scalatest.FunSuite

import scalaz._
import Scalaz._

class ValidationSpec extends FunSuite {

  test("validation |+|") {

   val result = "failed".fail[String] |+| {println("here"); "success".success[String]} |+| "failed".fail[String]

    println(result)
  }

  test("validation |@|") {

    val result = ("event 1 ok".success[String] |@| "event 2 failed!".failure[String] |@| "event 3 failed!".failure[String]) {_ + _ + _}

    println(result)
  }

  test("validation non empty list") {

    val result = ("event 1 ok".successNel[String] |@| "event 2 failed!".failureNel[String] |@| "event 3 failed!".failureNel[String]) {_ + _ + _}

    println(result)
    
  }

}
