trait A {
  val ping = println("ping")
}
class C extends A {
  override val ping = println("ping ................")
}
trait Cake {
  type T
}
class S { this: Cake =>
  type T <: A
  def t: T = this.t
//  t.ping
}
def f(x: Int) : Int = x * x * x  //> f: (x: => Int)Int
var y = 0                           //> y  : Int = 0
f ({
  y += 1
  println("invoked")
  y
})
def add(x: Int): Int = x + 3
def func(x: Int)(f: Int => Int = add): Int = f(x)
func(0)()
trait Request[T] {
  type Result = T
}
trait IntRequest extends Request[Int] {
}
trait Service[T] {
  def handle(x: T)
}
implicit val intService = new Service[Int] {
  override def handle(x: Int): Unit = {

  }
}


def test[T](in: Request[T]): T = in match {
  case i: IntRequest => 123
  case _ => sys.error(s"Unsupported request $in")
}
test(new IntRequest {})

test(new Request[String] {})
