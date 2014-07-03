class Foo
class Bar
class Something[A, B] {
  def doStuff()(implicit ev: A =:= B = null) = {
    if (ev == null) {
      println("do something")
    }
    else {
      println("do 123123123")
    }
  }
}
new Something[Foo, Bar].doStuff()
new Something[Foo, Foo].doStuff()
trait DoStuff[A, B] {
  def doStuff: Unit
}

trait DoStuff0 {
  implicit def neDoStuff[A, B]: DoStuff[A, B] =
    new DoStuff[A, B] {
      def apply(): Unit = {}
      override def doStuff: Unit = {
        println("different type")
      }
    }
}

object DoStuff extends DoStuff0 {
  implicit def eqDoStuff[A]: DoStuff[A, A] =
    new DoStuff[A, A] {
      def apply(): Unit = {
      }
      override def doStuff: Unit = {
        println("same type")
      }
    }
}

class Something3[A, B] {
  def doStuff()(implicit ds: DoStuff[A, B]) : Unit = ds.doStuff
}

new Something3[Foo, Bar].doStuff()
new Something3[Foo, Foo].doStuff()
trait =:!=[A, B]
implicit def neq[A, B] : A =:!= B = new =:!=[A, B] {}
implicit def neqAmbig1[A] : A =:!= A = ???
implicit def neqAmbig2[A] : A =:!= A = ???

