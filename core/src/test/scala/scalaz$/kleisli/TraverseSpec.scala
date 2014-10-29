package scalaz$.kleisli

import org.scalatest.FunSuite

import scalaz.concurrent.Future
import scalaz._
import Scalaz._
import scalaz.concurrent

class TraverseSpec extends FunSuite {

  test("simple sequence case") {
    val actual = List(Future.now(1), Future.now(2), Future.now(3)).sequence
    println(actual.run)
  }

  test("simple sequence case from scala standard library") {
//    import scala.concurrent.Future
//
//    val actual = List(Future.successful(1), Future.successful(2), Future.successful(3)).sequence
//    println(actual.run)
  }

  test("advanced sequence case") {
    case class Foo[A](x: A)

    object Foo123 {
      implicit val fooApplicative = new Applicative[Foo] {
        override def point[A](a: => A) = Foo(a)
        override def ap[A,B](fa: => Foo[A])(f: => Foo[A=>B]): Foo[B] = Foo(f.x(fa.x))
      }
    }


    import Foo123._

    val actual = List(Foo(1), Foo(2), Foo(3)).sequence

    println(actual)
  }

  test("simple traverseU case") {
    def fetchPost(postId: Int) = Future.now(postId.toString)

    val result = List(1,2,3).traverseU(fetchPost)

    println(result)
  }

  test("advanced traverseU case") {
//    case class Foo(x: Int)
//
//    val result = List(1,2,3).traverseU(Foo)
//
//    println(result)

  }

  test("simple traverseM case") {
    def foo(x: Int) = Future.now(List(1,2,3))

    val result = List(1,2,3).traverseM(foo)

    println(result.run)
  }

  test("advanced traverseM case") {

//    case class Foo[T[_] <: Seq]()
//
//    def foo(x: Int): Foo[List[Int]] = Foo[List[Int]]()
//
//    val result = List(1,2,3).traverseM(foo)
//
//    println(result)
  }

}
