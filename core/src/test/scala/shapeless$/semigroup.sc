case class Foo(i : Int, s : String)
class Test[T[_]] {
  def print = "print test"
}

implicit val test = new Test[List]
implicit val testMoreSpecific = new Test[List] {
  override def print = "print Foo"
}

def doStuff[A[_]](implicit test: Test[A]) = {
  test.print
}

doStuff[List[Foo]]

//
//val t: Either[String, Int] = Right(3)
//
//t.right
//
//import scalaz._, Scalaz._
//
//val result: String \/ Int = 3.right[String]
//
//val foo: Int = result.right | 4
//
//foo