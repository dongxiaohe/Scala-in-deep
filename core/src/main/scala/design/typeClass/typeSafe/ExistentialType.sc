//trait Foo[T] {
//  def one: Foo[_ >: T]
//  def two: T
//  def three(x: T)
//}
//
//def test[T, X <: T](f: Foo[T]) = {
//  val b = f.one
//  b.three(b.two)
//}

class A

class B

class C extends A

class Cat[_ <: A] {

}

new Cat[C]

val list = List(123, 0, 123)

list span ( _ > 1)

def strangeMethod[A](value: => A): A = value;

