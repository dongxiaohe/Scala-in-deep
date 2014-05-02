
trait Traversable[M[_]] {
  def reduceLeft[A](xs: M[A], f: (A, A) => A): A
}

implicit object intTraversable extends Traversable[List] {
  override def reduceLeft[Int](xs: List[Int], f: (Int, Int) => Int): Int = xs.reduceLeft(f)
}

implicit object stringTraversable extends Traversable[Seq] {
  override def reduceLeft[Int](xs: Seq[Int], f: (Int, Int) => Int): Int = xs.reduceLeft(f)
}

trait SemiGroup[T] {
  def append(x: T, y: T): T
}
implicit object intAddSemiGroup extends SemiGroup[Int] {
  override def append(x: Int, y: Int): Int = x + y
}
implicit object stringSemiGroup extends SemiGroup[String] {
  override def append(x: String, y: String): String = x + " " + y
}

def sum[M[Whatever], T](xs: M[T])(implicit g: SemiGroup[T], t: Traversable[M]) = t.reduceLeft(xs, g.append)

sum(List(1,2,3))
sum(List("hello", "world"))
sum(Seq("hello", "world"))

trait Identity[A] {
  val value: A

  def |+| (b: A)(implicit c: SemiGroup[A]): A = c.append(value, b)
}

implicit def convertAll[A](x: A): Identity[A] = new Identity[A] {
  override val value: A = x
}

3 |+| 4

"hello" |+| "world"

//List(1,2,3) |+| List(1,2,3∑)
