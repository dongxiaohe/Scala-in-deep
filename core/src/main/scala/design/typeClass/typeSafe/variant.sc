import scala.collection.immutable._

def foo(s: Set[CharSequence]): Unit = {
  println(s)
}

def bar(): Unit = {
  val s: Set[String] = Set("Hello", "World");
//  foo(s); //DOES NOT COMPILE, regardless of whether type is declared
  //explicitly in the val s declaration


  val result = Set("hello", "world")

  foo(result.toSet[CharSequence])
  foo(Set("hello", "world"))

}


trait =!=[A, B]

implicit def neq[A, B] : A =!= B = null
implicit def neqAmbig1[A] : A =!= A = null
implicit def neqAmbig2[A] : A =!= A = null

//trait Bar[T]
//
//implicit def bar1: Bar[String] = new Bar[String] {}
//
//implicit def bar3: Bar[String] = new Bar[String] {}
//
//class Foo[T](implicit ev: Bar[T])
//
//new Foo[String]

class A

class Foo[C <: A](implicit ev: C =!= A)

class C extends A

new Foo[C]


class Bar[C](implicit ev: C <:< A)

new Bar[A]

//new Foo[A]


