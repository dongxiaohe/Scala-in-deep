package typeClass

trait Comparable[T] {
  def comp(o:T) = this.hashCode - o.hashCode
}

class A extends Comparable[A] {
  override def comp(o:A) = super.comp(o)
}

class B(val i:Int) extends Comparable[B] {
  override def comp(o:B) = this.i - o.i
}


object TryThis {
  def main(args: Array[String]) = {

    def value[T](x: T): T => Seq[T] = x => Seq(x)

    import shapeless._ ; import HList._

    trait C[-T] {
      def a(x: T) : Int
    }

    println(new B(3).comp(new B(4)))

  }
}
