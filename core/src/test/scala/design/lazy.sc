def f = {
  println("hello world")
  3
}
object foo {

  lazy val once = f

  def doStuff = {
    lazy val value = f
    value
  }
}
foo.once
foo.doStuff
foo.once
foo.doStuff
foo.once
foo.doStuff
Seq("foo" -> Set(1), "foo" -> Set(2), "foo" -> Set(3)).groupBy(_._1)
  .mapValues(_.flatMap(_._2))
