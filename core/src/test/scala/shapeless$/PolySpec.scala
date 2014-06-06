package shapeless$

import org.scalatest.FunSuite
import shapeless._
import HList._
//import shapeless.syntax.singleton


class PolySpec extends FunSuite {

  test("poly specs") {
    object size extends Poly1 {
      implicit def caseInt = at[Int](x => 1)
      implicit def caseString = at[String](_.length)
      implicit def caseTuple[T, U]
      (implicit st : Case.Aux[T, Int], su : Case.Aux[U, Int]) =
        at[(T, U)](t => size(t._1)+size(t._2))
    }

    println(size(23))

    println(size("foo"))

    println(size((23, "foo")))

    println(size(((23, "foo"), 13)))

    println((23 :: "foo" :: false :: HNil).head)


    def polymorphicLength[T](l: List[T]): Int = l.length


    println(polymorphicLength(List(1, 2, 3)))

  }

  test("order") {

    class Foo(value: Int) {
      def getValue = value
    }

    class FooOrdering extends Ordering[Foo] {
      override def compare(a:Foo, b:Foo) = a.getValue compare b.getValue
    }

    implicit val ordering: Ordering[Foo] = new FooOrdering

//    def max[T](a: T, b: T): T = implicitly[Ordering[T]].max(a, b)
    def max[T](a: T, b: T)(implicit op: Ordering[T]): T = op.max(a, b)

    max(new Foo(1), new Foo(123)).getValue
    max(1, 3)


  }

}
