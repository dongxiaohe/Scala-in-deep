package shapeless$

import shapeless._
import poly._

object GenericSpec {

  def main(args: Array[String]) = {

//    import shapeless._
//    case class Foo(i: Int, s: String, b: Boolean)
//
//    val fooGen = Generic[Foo]
//
//    val foo = Foo(23, "foo", true)
//
//    val result = fooGen.to(foo)
//
//    val changed = 13 :: result.tail
//
//    val newFoo = fooGen.from(changed)
//
//    println(newFoo)

    object TypeMapper extends Poly1 {
      implicit def caseInt     = at[Int](identity)
      implicit def caseLong    = at[Long](identity)
      implicit def caseString  = at[String](identity)
    }

    case class Foo(x: String, y: Long, z: Int)

    val filter = (predicate: Int => Boolean, xs: List[Int]) => {
      for (x <- xs if predicate(x)) yield x
    }

    def isEven(x: Int) = x % 1 == 0
    println(filter(isEven, List(1,2,3,4)))

  }



}
