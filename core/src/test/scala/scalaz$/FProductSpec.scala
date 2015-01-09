package scalaz$

import org.scalatest.FunSuite

class FProductSpec extends FunSuite {



  test("fproduct") {
    import scalaz._
    import Scalaz._

    val collection = List(1, 2, 3)

    println(collection.fproduct(_.toString))
  }


  test("whatever") {
    implicit class DoStuff[A](val a: A) {
      def doStuff: String = "123"
    }

    println(123.doStuff)

    println(None.asInstanceOf[Option[String]].flatMap(t => Some(t)))

    import scalaz.syntax.traverse.ToTraverseOps // F[A] => TraverseOps[F, A]
    import scalaz.std.list.listInstance // Traverse[List]
    import scalaz.std.option.optionInstance // Applicative[Option]

    val result = List(1, 2, 3).traverseU{ Option(_) }


  }


}
