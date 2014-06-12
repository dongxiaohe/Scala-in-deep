package shapeless$.poly

import org.scalatest.FunSuite

class SimplePolySpec extends FunSuite {

  test("poly function") {

    trait PolyFunction[F[_]] {
      def apply[T](t: T): F[T]
    }

    object singleton extends PolyFunction[Set] {
      def apply[T](t: T): Set[T] = Set(t)
    }

    println(singleton(23))

  }

  test("recursive type") {

    type Const[C] = {
      type λ[T] = C
    }

    println(implicitly[Const[Int]#λ[String] =:= Int])

    println(implicitly[Const[Int]#λ[Boolean] =:= Int])

    println(implicitly[String =:= String])

  }

  test("poly function types") {

    trait ~> [F[_], G[_]] {
      def apply[T](f : F[T]) : G[T]
    }

    type Const[C] = {
      type λ[T] = C
    }

    type Id[T] = T

    object size extends (Id ~> Const[Int]#λ) {
      def apply[T](t : T) : Int = t match {
        case l : List[_] => l.length
        case s : String  => s.length
        case _ => 0
      }
    }

    object singleton extends (Id ~> Set) {
      def apply[T](t : T) : Set[T] = Set(t)
    }

    println(size(23))

    implicit def polyToMono[F[_], G[_], T](f : F ~> G) : F[T] => G[T] = f(_)

    implicit def polyToMono2[G[_], T](f : Id ~> G) : T => G[T] = f(_)
    implicit def polyToMono3[F[_], T](f : F ~> Id) : F[T] => T = f(_)
    implicit def polyToMono4[T](f : Id ~> Id) : T => T = f[T](_)
    implicit def polyToMono5[F[_], G, T](f : F ~> Const[G]#λ) : F[T] => G = f(_)
    implicit def polyToMono6[G, T](f : Id ~> Const[G]#λ) : T => G = f(_)

    List(1, 2, 3) map singleton


  }

  test("poly aux") {
    import shapeless._

    object size extends Poly1 {
      implicit def caseInt = at[Int](x => 1)
      implicit def caseString = at[String](_.length)
      implicit def caseTuple[T, U]
      (implicit st : Case.Aux[T, Int], su : Case.Aux[U, Int]) =
        at[(T, U)](t => size(t._1)+size(t._2))
      implicit def caseTriple[T, U, R]
      (implicit st : Case.Aux[T, Int], su : Case.Aux[U, Int], r: Case.Aux[R, Int]) =
        at[(T, U, R)](t => size(t._1)+size(t._2)+size(t._3))
    }

    println(size(((123, 1234567, "foo"), 13)))


  }

}
