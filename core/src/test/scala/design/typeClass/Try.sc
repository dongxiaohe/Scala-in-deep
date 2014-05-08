//
//trait Foo[T] {
//  def one: Foo[_ >: T]
//  def two: T
//  def three(x: T)
//}
//
//def test[T](f: Foo[T]) = {
//  val b = f.one
//  b.three(b.two)
//}

//trait Foo[T] {
//  def one[X >: T]: Foo[X]
//  def two: T
//  def three(x: T)
//}
//
//def test[T, X >: T](f: Foo[T]) = {
//  val b = f.one[X]
//  b.three(b.two)
//}

class Foo[A]

type Outer = List[Foo[T]] forSome { type T }
type Inner = List[Foo[T] forSome { type T }]

val outer: Outer = List(new Foo[Char], new Foo[Char], new Foo[Char])
val inner: Inner = List(new Foo[Char], new Foo[Int])
