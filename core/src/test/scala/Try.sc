import scala.collection.generic.CanBuildFrom
import scala.collection.mutable
import scala.reflect.{classTag, ClassTag}
abstract class Test[T:ClassTag];
class Test_1[T:ClassTag] extends Test
class Test_3[T:ClassTag] extends Test[T]
def t[A] = (l:Seq[A]) => l tail
def r[A] = (r:Seq[A]) => r reverse

(Function.chain(List(r[Int], t[Int], r[Int])))(List(1,2,3,4))

def tr[A] = ((x: List[A]) => x.tail) compose ((x: List[A]) => x.reverse)

class Builder[-Elem, +To] {

}

class A

class ExtendA extends A

val result: Builder[ExtendA, A] = new Builder[A, A]

import scala.collection.breakOut

val map : Map[Int,String] = List("London", "Paris").map(x => (x.length, x))(breakOut)

class Foo(x: String) {

  def get(): String = x
}

class Bar(x: String) {
}

class BarBuilder[String, Bar] extends Builder {

}

//implicit val build = new CanBuildFrom[Foo, String, Bar] {
//  override def apply(): BarBuilder[String, Bar] = new BarBuilder[String, Bar]
//
//  override def apply(from: Foo): BarBuilder[String, Bar] = new BarBuilder[String, Bar]
//}

//def convert(x: Foo)(implicit cbf: CanBuildFrom[Foo, String, Bar]): Bar = {
//  val t = cbf() += x.get()
//
//  t.result()
//}

class CCC {

}

implicit def addMethod(x: CCC) = new {

  def doStuff: Unit= println(123)

}

new CCC doStuff


List.tabulate(3)(_ + 1).map(a => (a, a.toString))

List.tabulate(3)(_ + 1).map(_.toString)(breakOut)

val foo : Map[Int,String] = List.tabulate(3)(_ + 1).map(a => (a, a.toString))(breakOut)












