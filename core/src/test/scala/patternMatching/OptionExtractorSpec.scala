package patternMatching

import org.scalatest.FunSuite

class OptionExtractorSpec extends FunSuite {

  class User(val name: String, val age: Int)

  object User {
    def unapply(user: User): Option[(String, Int, Boolean)] = {
      Some((user.name, user.age, false))
    }
  }

  test("option extractor") {
    new User("123", 123) match {
      case User(x, y, z) => println("working")
      case _ => println("oh no")
    }

    lazy val xs: Stream[Int] = 0 #:: xs.scanLeft(1)(_ + _)

    xs match {
      case first #:: second #:: _ => println("working")
      case _ => -1
    }

    val list = 3 :: 6 :: 13 :: Nil
    list match {
      case List(a, b, _*) => println("working")
      case List(a, b, c) => println(a + b + c)
      case _ => 0
    }


  }

}
