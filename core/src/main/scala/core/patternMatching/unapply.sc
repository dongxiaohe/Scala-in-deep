//object Hello {
//  def unapply(s:String): Option[String] = Some(s)
//}
//
//
//"hello" match {
//  case Hello(s) => println(s)
//
//}
//
//Hello.unapply("hello") match {
//  case Some(s) => println(s)
//  case _ =>
//}

//trait Foo
//
//trait Bar[T <: Foo] {
//  def bar[W <: Foo]: W = new Foo {} //doesn't compile
//}

//trait Foo {
//  protected val fish: String
//}
//
//class Bar extends Foo {
//  override protected val fish = "catfish"
//}
//
//val bar = new Bar
//bar.fish

List(1,2,3).take(100)


object %:: {
  def unapply(xs: String): Option[(Char, String)] =
    if (xs.isEmpty) None
    else Some((xs.head, xs.tail))
}

val x %:: xs = "555"

println(x)