package scalaz$

import org.scalatest.FunSuite
import scalaz._
import Scalaz._

class TraverseUSpec extends FunSuite {

  test("map and reduceLeft") {
    val foo = List("1", "2", "3")

    println(foo.traverseU(_.toInt))
  }

  test("map and sequence for basic type") {

    case class Foo(x: Int)

    val foo = List(Foo(1), Foo(2), Foo(3))

    println(foo.traverseU(_.x))

  }

  test("map and sequence for customized type with List") {

    case class Foo[T](x: T)
    case class Bar[T](x: T)

    object Whatever {
      implicit val fooApplicative = new Applicative[Bar] {
        override def point[A](a: => A) = Bar(a)
        override def ap[A,B](fa: => Bar[A])(f: => Bar[A=>B]): Bar[B] = Bar(f.x(fa.x))
      }
    }

    import Whatever._

    def to[T](x: Foo[T]) = Bar(x.x)

    val foo = List(Foo(1), Foo(2), Foo(3))

    println(foo.traverseU(to))

  }

  test("map and sequence for G[T[A]] => T[G[A]]") {
    case class Base[T](x: T)

    case class Foo[T[_]](x: T[_])

    case class Bar[T](x: T)

    def to[T](x: Base[T]): Bar[T] = Bar(x.x)

    val foo = Foo(Base(3))

    ???
  }

}
