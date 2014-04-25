package design.implicits.scope

import org.scalatest.{FlatSpec, FunSuite}

class ImplicitTest extends FlatSpec {

  "implicit class" should "enrich current class ability" in {

    class Foo

    implicit class Add(foo : Foo) {
      def doStuff = "hello world"
    }

    assert(new Foo().doStuff === "hello world")

  }

  "implicit argument with manifest" should "enrich class behaviour" in {

    def foo[T](x: List[T])(implicit m: Manifest[T]) = {
      if (m <:< manifest[String])
        println("Hey, this list is full of strings")
      else
        println("Non-stringy list")
    }

    foo(List("123"))

  }

  "implicit object" should "discouple the client logic" in {
    case class Address(no: Int, street: String, city: String,
                       state: String, zip: String)


    trait LabelMaker[T] {
      def toLabel(value: T): String
    }

    implicit object AddressLabelMaker extends LabelMaker[Address] {
      def toLabel(address: Address): String = {
        import address._
        "%d %s, %s, %s - %s".format(no, street, city, state, zip)
      }
    }

    def printLabel[T](t: T)(implicit lm: LabelMaker[T]) = lm.toLabel(t)

    println(printLabel(Address(100, "Monroe Street", "Denver", "CO", "80231")))

  }


  "implicit" should "constrain type" in {
    trait Dummy
    object c extends Dummy
    def doStuff[A](x: A)(implicit y: A <:< Dummy) = x
    def show[A <: Dummy](x: A)= x

    println(doStuff(new Dummy{}))
    println(show(new Dummy{}))
  }

  "function" should "can take anything to result" in {

    def doStuff(f: Int => String): String = f(4)

    val result = doStuff(_ => "3")

    println(result)
  }

  "curried" should "change method to function" in {
    def add(x: Int, y: Int) = x + y

    val addR: (Int, Int) => Int = _ + _

    val addCurried = (add _).curried

    println(addCurried(3)(4))

    println(addR.curried(3)(4))
  }

}