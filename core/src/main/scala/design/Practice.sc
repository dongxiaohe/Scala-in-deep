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
