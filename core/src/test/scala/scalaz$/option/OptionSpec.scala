package scalaz$.option

import org.scalatest.FunSuite
import scalaz._
import Scalaz._


class OptionSpec extends FunSuite {

  test("the difference between scala option and scalaz option") {
    (Some(3): Option[Int]) getOrElse "3"
    (some(3): Option[Int]) getOrElse "3"
    some(3) some {_ + 1} none 123

    println(3.some |+| 4.some)
  }

  test("type class") {
    import shapeless._
    import Nat._
    import HList._

    def typed[T](t : => T) {}

    val unsorted = _3 :: _1 :: _4 :: _0 :: _2 :: HNil
    println(typed[_3 :: _1 :: _4 :: _0 :: _2 :: HNil](unsorted))

    def prod[A <: Nat, B <: Nat](implicit prod : Prod[A, B]) =
      new { def toInt(implicit ti : ToInt[prod.Out]) = ti() }

    println(prod[_3, _3].toInt)

//    case class Foo[T](x: T)
//
//    def combineHLatest[L <: HList](l: L)(implicit r: LeftReducer[L, combine.type]) =
//      l.reduceLeft(combine)
//
//    object combine extends Poly {
//      implicit def caseFoo[A, B <: HList] = use(
//        (f1: Foo[A], f2: Foo[B]) => Foo(f1.x :: f2.x)
//      )
//    }
//
//    def combineHLatest[L <: HList](l: L)(implicit
//                                         r: RightFolder[L, Foo[HNil], combine.type]
//      ) = l.foldRight(Foo(HNil: HNil))(combine)

  }

}
