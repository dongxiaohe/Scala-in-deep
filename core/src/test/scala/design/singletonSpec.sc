import scala.Singleton

trait OnlyForObjects  { this: scala.Singleton =>
}

//object Foo extends OnlyForObjects


//class Bar extends OnlyForObjects

val sumOf1to3 = 1 + 2 + 3

def sum(x: List[Int]) = x.foldLeft(0)(_ + _)

//trait Foldable[F[_]] {
//
//  def fold[A, B](x: F[A], initial: B, f: (B, A) => B): B
//
//}
//
//val listIntFoldable =  new Foldable[List] {
//  override def fold[A, B](x: List[A], initial: B, f: (B, A) => B): B = x.foldLeft(initial)(f)
//}
//
def doStuff[A, B](f: (B, A) => B)(x: List[A]) = {

}

//doStuff((x: Int, y) => x)(List(3))
//doStuff((x: Int, y) => x)(Nil)

def test(x: Int => String) = {

}
test(t => t.toString)

//trait Monoid[M] {
//  def zero: M
//  def add(m1: M, m2: M): M
//}
//
//trait Foldable[F[_]] {
//  def foldl[A, B](as: F[A], z: B, f: (B, A) => B): B
//  def foldMap[A, B](as: F[A], f: A => B)(implicit m: Monoid[B]): B =
//    foldl(as, m.zero, (b: B, a: A) => m.add(b, f(a)))
//}
//
//def mapReduce[F[_], A, B](as: F[A], f: A => B)
//                         (implicit ff: Foldable[F], m: Monoid[B]) =
//  ff.foldMap(as, f)
//
//case class Sum(value: Int)
//case class Product(value: Int)
//
//implicit val sumMonoid = new Monoid[Sum] {
//  def zero = Sum(0)
//  def add(a: Sum, b: Sum) = Sum(a.value + b.value)
//}
//
//implicit val productMonoid = new Monoid[Product] {
//  def zero = Product(1)
//  def add(a: Product, b: Product) = Product(a.value * b.value)
//}
//
//implicit val listFoldable = new Foldable[List] {
//  def foldl[A, B](as: List[A], z: B, f: (B, A) => B) = as.foldLeft(z)(f)
//}
//
//val sumOf123 = mapReduce(List(1,2,3), Sum)
//


import scalaz._
import Scalaz._
case class Foo(x: Int)
val e: Either[String, Int] = Right(5)
def add100(x: Int): Either[String, Int] = Right(x + 100)
e.fold(identity, add100)
e.right.flatMap(add100)
case class T (a:String,b:String,c:String)
val x=T("a","b","c")
s"${x.c}"

class Whatever(a: Int, b: Int, c: Int)

object Whatever extends ((Int, Int, Int) => Whatever) {


  def apply(a: Int, b: Int, c: Int): Whatever = {
    new Whatever(a, b, c)
  }

}

def foo(f: (Int, Int, Int) => Whatever) = f(1,2,3)

foo(Whatever)