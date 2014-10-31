package scalaz$

import org.scalatest.FunSuite

import scalaz._
import Scalaz._

class EitherSpec extends FunSuite {

  type Either = \/[String, Int]

  test("either type |+|") {

    def foo(): Either = {
      println("processing foo")
      "3".left[Int]
    }

    def bar(): Either = {
      println("processing bar")
      3.right[String]
    }

    val result = foo |+| bar

    assert(result.isLeft)
  }

  test("either type flatMap") {

    def foo(): Either = {
      println("processing foo")
      "3".left[Int]
    }

    def bar(): Either = {
      println("processing bar")
      3.right[String]
    }

    val result = foo().flatMap(_ => bar())

    assert(result.isLeft)
  }

  test("either type flatMap success") {

    def foo(): Either = {
      println("processing foo")
      3.right[String]
    }

    def bar(): Either = {
      println("processing bar")
      3.right[String]
    }

    val result = foo().flatMap(_ => bar())

    assert(result.isRight)

  }

  test("either type |@|") {

    def foo(): Either = {
      println("processing foo")
      "3".left[Int]
    }

    def bar(): Either = {
      println("processing bar")
      3.right[String]
    }

    val result = (foo() |@| bar()) {_ + _}

    assert(result.isRight)

  }

  test("either type |+| with for loop") {

    def foo(): Either = {
      println("processing foo")
      "3".left[Int]
    }

    def bar(): Either = {
      println("processing bar")
      3.right[String]
    }

    val result = for {
      t <- foo()
      r <- bar()
    } yield t |+| r

    assert(result.isLeft)

  }

}
