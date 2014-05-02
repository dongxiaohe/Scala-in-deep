package core.patternMatching

import org.scalatest.FunSuite

class UnapplySeqSpecs extends FunSuite {

  test("an example of unapplySeq") {

    object GivenNames {
      def unapplySeq(name: String): Option[Seq[String]] = {
        val names = name.trim.split(" ")
        if (names.forall(_.isEmpty)) None else Some(names)
      }
    }

    def greetWithFirstName(name: String) = name match {
      case GivenNames(firstName, _*) => "Good morning, " + firstName + "!"
      case _ => "Welcome! Please make sure to fill in your name!"
    }

    println(123)
    println(greetWithFirstName("Daniel"))

  }

  test("an example of extract first name and given name") {
    object Names {
      def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
        val names = name.trim.split(" ")
        if (names.size < 2) None
        else Some((names.last, names.head, Seq(names.drop(1).dropRight(1): _*)))
      }
    }

    def greet(fullName: String) = fullName match {
      case Names(lastName, firstName, _*) => "Good morning, " + firstName + " " + lastName + "!"
      case _ => "Welcome! Please make sure to fill in your name!"
    }

    println(greet("Daniel Dean abc Steve"))
  }

}
