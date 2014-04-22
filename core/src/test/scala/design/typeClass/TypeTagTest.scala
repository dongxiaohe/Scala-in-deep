package design.typeClass

import org.scalatest.FunSuite

class TypeTagTest extends FunSuite {

  test("type tag") {

    import scala.reflect.runtime.universe._


    //    def doStuff[A](xs: List[A])(implicit a: Manifest[A]) = xs match {
    //      case _: List[String] => "list of strings"
    //      case _: List[Foo] => "list of foos"
    //    }


    def doStuff[A : TypeTag](xs: List[A]) = typeOf[A] match {
      case t if t =:= typeOf[String] => "list of strings"
      case t if t <:< typeOf[Foo] => "list of foos"
    }

    println(doStuff(List(new Bar)))

  }


}
class Foo
class Bar extends Foo