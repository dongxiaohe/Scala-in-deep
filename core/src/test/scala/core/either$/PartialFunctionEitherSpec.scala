package core.either$

import org.scalatest.FunSuite

class PartialFunctionEitherSpec extends FunSuite {


  test("lift a partial function") {
    def usingIsDefinedAt[A, B, C](pf : PartialFunction[A, B])(c: A => C) : A =>  Either[C, B] = { a => if (pf.isDefinedAt(a)) Right(pf(a)) else Left(c(a)) }

    def usingAndThen[A, B, C](pf: PartialFunction[A, B])(c: A => C): A => Either[C, B] =(pf andThen Right.apply) orElse PartialFunction(c andThen Left.apply)

    def usingLiftAndFold[A, B, C](pf: PartialFunction[A, B])(c: A => C): A => Either[C, B] = (a: A) => pf.lift(a).fold[Either[C, B]](Left(c(a)))(Right(_))
  }

  test("scalaz either") {

    import scalaz._
    import Scalaz._

    def filterExec[T, W](pf: PartialFunction[T, T] *)(c: T => W): T => \/[T, W] = { t =>
      if (pf.forall(r => r.isDefinedAt(t))) c(pf.reduceLeft(_ orElse _)(t)).right[T]
      else t.left[W]
    }

    def isValid: PartialFunction[Int, Int] = {
      case t: Int if t >= 40 => t
    }

    def foo: PartialFunction[Int, Int] = {
      case t: Int if t >= 7 => t
    }


    println((isValid andThen foo).isDefinedAt(30))

    assert(filterExec(isValid, foo)(println)(3).isLeft)
    assert(filterExec(isValid, foo)(println)(30).isLeft)
    assert(filterExec(isValid, foo)(println)(3000).isRight)

  }

  test("ignore rest") {
    import scalaz._
    import Scalaz._

    def chainExec[T, W](pf: PartialFunction[T, T] *)(c: T => W): T => \/[T, W] = { t =>
      val chain = pf.reduceLeft(_ orElse _)
      if (chain.isDefinedAt(t)) c(chain(t)).right[T]
      else t.left[W]
    }

    def isValid: PartialFunction[Int, Int] = {
      case t: Int if t >= 40 => t
    }

    def foo: PartialFunction[Int, Int] = {
      case t: Int if t >= 7 => t
    }


    println((isValid andThen foo).isDefinedAt(30))

    assert(chainExec(isValid, foo)(println)(3).isLeft)
    assert(chainExec(isValid, foo)(println)(30).isRight)
    assert(chainExec(isValid, foo)(println)(3000).isRight)
  }

}
