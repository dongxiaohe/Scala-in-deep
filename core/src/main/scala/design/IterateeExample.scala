package design


object IterateeExample {

  def enumerate[E,A]: (List[E], IterV[E,A]) => IterV[E,A] = {
    case (Nil, i) => i
    case (_, i@Done(_, _)) => i
    case (x :: xs, Cont(k)) => enumerate(xs, k(El(x)))
  }

  def counter[A]: IterV[A,Int] = {
    def step(n: Int): Input[A] => IterV[A,Int] = {
      case El(x) => Cont(step(n + 1))
      case Empty => Cont(step(n))
      case EOF => Done(n, EOF)
    }
    Cont(step(0))
  }

  def drop[E,A](n: Int): IterV[E,Unit] = {
    def step: Input[E] => IterV[E,Unit] = {
      case El(x) => drop(n - 1)
      case Empty => Cont(step)
      case EOF => Done((), EOF)
    }
    if (n == 0) Done((), Empty) else Cont(step)
  }

  def head[E]: IterV[E, Option[E]] = {
    def step: Input[E] => IterV[E, Option[E]] = {
      case El(x) => Done(Some(x), Empty)
      case Empty => Cont(step)
      case EOF => Done(None, EOF)
    }

    Cont(step)
  }

  def composition[E]: IterV[E, Option[E]] = for {
    _ <- drop(4)
    x <- head
  } yield x

//  def alternates[E](n: Int): IterV[E, List[E]] =
//    composition[E].replicate[List](n).
//      foldRight(Done(List[Option[E]](),Empty))((x, y) => for {
//      h <- x
//      t <- y
//    } yield h :: t).map(_.flatten)

  def main(args: Array[String]) {
    val length: Int = enumerate(List(1,2,3), counter[Int]).run

    println(length)

    println(enumerate(List(1,2,3,4), drop[Int, Unit](3)))

    println(enumerate(List(3), head[Int]).run)


    println(enumerate(List(1,2,3,4,5), composition[Int]))

  }

}
trait Input[+E]
case class El[E](e: E) extends Input[E]
case object Empty extends Input[Nothing]
case object EOF extends Input[Nothing]

trait IterV[E,A] {
  def run: A = {
      this match {
        case Done(a, _) => a
        case Cont(k) => k(EOF).run
        case _ => throw new Exception
      }
  }

  def flatMap[B](f: A => IterV[E,B]): IterV[E, B] = this match {
    case Done(x, e) => f(x) match {
      case Done(y, _) => Done(y, e)
      case Cont(k) => k(e)
    }
    case Cont(k) => Cont(e => k(e) flatMap f)
  }

  def map[B](f: A => B): IterV[E, B] = this match {
    case Done(x, e) => Done(f(x), e)
    case Cont(k) => Cont(e => k(e) map f)

  }

}
case class Done[E,A](a: A, e: Input[E]) extends IterV[E,A]
case class Cont[E,A](k: Input[E] => IterV[E,A]) extends IterV[E,A]