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
