class A(val n: Int)
class B(val m: Int, val n: Int)
class C(val m: Int, val n: Int, val o: Int) {
  def total = m + n + o
}

implicit def toA(n: Int): A = new A(n)
implicit def aToB[A1 <% A](a: A1): B = new B(a.n, a.n)
implicit def bToC[B1 <% B](b: B1): C = new C(b.m, b.n, b.n)


println(5.total)
println(new A(5).total)
println(new B(5, 5).total)
println(new C(5, 5, 5).total)
import scalaz.Scalaz._
val names = Map("Sidney" -> 1 , "Paul" -> 1 , "Jacob" -> 7)
val moreNames = Map("Sidney" -> 1 , "Paul" -> 5 , "Nick" -> 3)
names ++ moreNames.map(t => t._1 -> (t._2 + names.getOrElse(t._1, 0)))
(names.toSeq ++ moreNames.toSeq).groupBy(_._1).mapValues(t => t.map(_._2).toList)
//magic scalaz
val test = List(names , moreNames).reduce(_ |+| _)
val listTest = names.map(t => t._1 -> List(t._2)) |+| moreNames.map(t => t._1 -> List(t._2))


