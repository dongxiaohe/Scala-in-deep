trait Function1[-T, +R] {
  def apply(v : T) : R
}

val stringSingletonFn = new Function1[Int, Set[Int]] {
  def apply(v : Int) : Set[Int] = Set(v)
}

def toSet[T](x: T): Set[T] = Set(x)

//val toSetFun = toSet _

val foo = stringSingletonFn.apply _

List.tabulate(3)(_+1) map toSet

import shapeless._
import HList._

//(23 :: "foo" :: false :: HNil) map toSet


trait Foo[A <: Foo[_]] {
  def f: A
}

class Bar extends Foo[Bar] {
  def f: Bar = new Bar
}

val fullString = "1234567"
val bar = "45"

fullString.split(bar.toArray).toList

val orignal = List(1, 2, 3, 4, 5, 6)
val result = List(4, 5, 6)

orignal.diff(result)
