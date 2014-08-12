val list = List(1,2,3)
list match {
  case head :: tail => println(s"h:${head} ~ t: ${tail}")
  //  case Nil =>
}


val result = List(1,2,3,4,5,6).sliding(3)
//result.size
result.next()
result.next()

class Foo(val x: Int) {

}


object Foo {


  def unapply(foo: Foo): Option[String] = {
    Some(foo.x.toString)
  }

}


val foo = new Foo(3)

foo match {

  case Foo("3") => "hello world"


}

List(1,2,3).map(_.toString)

def add(x: Int): Int = x
def take(f: Int => Int) = {
  f(3)
}
take(add)


def f(x: String): String = "123"

(f _).isInstanceOf[Function0[_]]
(f _).isInstanceOf[Function1[_, _]]
