package scalaz.builder

import scalaz._
import Scalaz._

object ApplicativeBuilderSpec {

  def handle(func: Option[(Int) => Int], value: Option[Int]): Option[Int] = {

    val result: Int = func.get(value.get)
    result.point[Option]
  }

  def handle(a: String, b: String, c: String) : Option[BigDecimal] = {
    for {
      a <- Option(a)
      b <- Option(b)
      c <- Option(c)
    } yield (BigDecimal(a).point[Option] |@| BigDecimal(b).point[Option] |@| BigDecimal(c).point[Option])(_ + _ + _).get
  }

}
