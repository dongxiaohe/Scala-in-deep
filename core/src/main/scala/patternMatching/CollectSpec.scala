package patterMatching

object CollectSpec {
  def filter(foos: Seq[Foo]): Seq[Qux] = {
    foos collect {case qux : Qux => qux}
  }


}
trait Foo
case class Bar(value: String)
case class Qux(bar: Bar, value: String) extends Foo
case class Corge(grault: Int) extends Foo

