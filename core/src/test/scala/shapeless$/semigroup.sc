case class Foo(i : Int, s : String)
class Test[T] {
  def print = "print test"
}

implicit val test = new Test[Any]
implicit val testMoreSpecific = new Test[Foo] {
  override def print = "print Foo"
}

def doStuff[A](implicit test: Test[A]) = {
  test.print
}

doStuff[Foo]


val t: Either[String, Int] = Right(3)

t.right

import scalaz._, Scalaz._

val result: String \/ Int = 3.right[String]

val foo: Int = result.right | 4

foo