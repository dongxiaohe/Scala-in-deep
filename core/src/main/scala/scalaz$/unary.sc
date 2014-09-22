//import scalaz._ ; import Scalaz._
//
//val List(a,b,c,d) = List(Some("str1"), Some("str2"),None,Some("str3"))


def a(x: String => String) = "3"

a(_.toString)

val result = Map("whatever" -> 1, "qwe" -> 2, "abc" -> 123)
result.toSet

import scalaz._
import Scalaz._

// Some methods that take simple types and return higher-kinded types
//def str(x: Int): Option[String] = Some(x.toString)
//def toInt(x: String): Option[Int] = Some(x.toInt)
//def double(x: Int): Option[Double] = Some(x * 2)
//
//// Lets compose those functions Ye Olde Way
//def oldSchool(i: Int) =
//  for (x <- str(i);
//       y <- toInt(x);
//       z <- double(y))
//  yield z
//
//// Kleisli!
//4.some >>= (f >=> g)
//val funky = Kleisli(str _) >=> Kleisli(toInt _) >=> Kleisli(double _)
//
//println(oldSchool(1)) // Some(2.0)
//println(funky(1))     // Some(2.0)
//
//// Lets use symbols!
//val reallyFunky = ☆(str) >=> (toInt _) >=> (double _)

def add: Int => Int = t => t + 3
def multiply: Int => Int = t => t * 3
def stringnify: Int => String = t => t.toString
(stringnify compose (add andThen multiply))(6)

val reader = for {
  i <- Reader(add)
  j <- Reader(multiply)
} yield j

reader(3)

class Foo(x: String)
object Foo extends Foo("3")