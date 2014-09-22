import scalaz.ValidationNel
import scalaz._
import Scalaz._

case class Foo(singleVal: ValidationNel[Throwable, String])

val x = some(Foo("hey".success))

val y = none[Foo]

println(x.traverseU(_.singleVal))
println(y.traverseU(_.singleVal))
3.0 ?|? 3.0
some(2.0) max some(1.0)
//def doStuff(x: Int)(implicit t: 1.0 ?|? 2.0) = x
//
//doStuff(0)

class User
class Checkin
type Tagged[U] = { type Tag = U }
type @@[T, U] = T with Tagged[U]
class Tagger[U] {
  def apply[T](t : T) : T @@ U = t.asInstanceOf[T @@ U]
}
def tag[U] = new Tagger[U]

// Manual specialization needed here ... specializing apply above doesn't help
def tag[U](i : Int) : Int @@ U = i.asInstanceOf[Int @@ U]
def tag[U](l : Long) : Long @@ U = l.asInstanceOf[Long @@ U]
def tag[U](d : Double) : Double @@ U = d.asInstanceOf[Double @@ U]
def fetch[A](id: Int @@ A): A = null.asInstanceOf[A]
val id = tag[Checkin](10)
fetch[Checkin](id) // Compiles
fetch[User](id)