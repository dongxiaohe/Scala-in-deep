package shapeless$

import shapeless._
import poly._

object PolySpec {



  def main(args: Array[String]) {
    println(choose(List(3)))
  }
}

object choose extends (List ~> Option) {
  override def apply[T](f: List[T]): Option[T] = f.headOption
}