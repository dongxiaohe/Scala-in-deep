import scala.util.Try

trait Element[T <: Typed] {
  def eval: Try[T]
}

trait Typed

case class NumberLike(n: Long) extends Typed

case class SomeElement(n: Long) extends Element[NumberLike] {
  override def eval = Try {
    NumberLike(n)
  }
}

object app extends Application {
  println (SomeElement(5).eval)
}