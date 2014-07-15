package core.patternMatching

import org.scalatest.FunSuite

class ListOptionSpec extends FunSuite {

  test("list of option pattern matching") {

    object AllSome {
      def unapply[T](l: List[Option[T]]) = l.forall(_.isDefined)
    }

    object AllNone {
      def unapply[T](l: List[Option[T]]) = l.forall(_ == None)
    }

    object Mixed {
      def unapply[T](l: List[Option[T]]) = !AllNone.unapply(l) && !AllSome.unapply(l)
    }

    val list:List[Option[String]] = List(Some("aaa"), None, Some("bbb"), Some("ccc"))

    val result = list match {

      case AllSome() => "all some"
      case AllNone() => "all none"
      case Mixed() => "mixed"

    }

    println(result)

  }

}
