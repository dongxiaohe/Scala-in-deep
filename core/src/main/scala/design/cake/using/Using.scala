package design.cake.using

import scala.Int

abstract class Using[T, W] {

  protected def need(x: T): W

  def apply[R](x: T)(f: W => R): R = {
    val resource = need(x)

    f(resource)
  }
}

case class Foo(x: Int) {

  val process = "processing ... " + x

}

class FooUsing extends Using[Int, Foo] {

  override def need(x: Int): Foo = Foo(x)

}

class ImplicitFooUsing(implicit t: Int) extends Using[Int, Foo] {

  override def need(x: Int): Foo = Foo(x + t)

}

object Main {

  def process(foo: Foo) = foo.x

  def main(args: Array[String]) = {
    implicit val x = 3

    val fooUsing = new FooUsing()

    val implicitFooUsing = new ImplicitFooUsing

    println(fooUsing(3){x: Foo => x.process})
    println(implicitFooUsing(3){x: Foo => x.process})

  }

}
