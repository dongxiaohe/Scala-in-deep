import scala.collection.generic.CanBuildFrom

Some("123").fold("qwe"){str => f(str)}
def f(s: String): String = s + "123"
class Common {
}
class Foo {
  def doStuff(): Unit = {}
}
class Bar {
  def doStuff(): Unit = {}
}
implicit def foo(x: Common): Foo = new Foo
implicit def bar(x: Common): Bar = new Bar
val common = new Common
//common.doStuff()

implicitly[CanBuildFrom[List[Int], String, List[String]]]

List(1,2,3).map(_.toDouble)

def func: Int => Int = {
  println("processing func")
  _ + 3
}
def add: String => Int = {
  println("processing add")
  _.toInt + 3
}
val result = func compose add
result("3")
class Test[+A] {
  def test[B >: A](b: B)(implicit ev: B =:= C): B = b
}

class C

class ExtendC extends C

val test = new Test[ExtendC]

test.test(new C)