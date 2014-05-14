import java.io.{FileNotFoundException, File}
import java.net.URL
import scala.concurrent.Future
import scala.io.Source
import scala.util.{Failure, Success, Try}

//class Foo[A]
//
//type Outer = List[Foo[T]] forSome { type T }
//type Inner = List[Foo[T] forSome { type T }]
//
//val outer: Outer = List(new Foo[Char], new Foo[Char], new Foo[Char])
//val inner: Inner = List(new Foo[Char], new Foo[Int])
val s = List("1","2","3","4","5")
val grouped = s.grouped(3).toList
grouped flatMap(_ :+ "c")

//unmanagedSourceDirectories in Compile <+= (scalaVersion, sourceDirectory in Compile) {
//  case (v, dir) if v startsWith "2.9" => dir / "scala_2.9"
//  case (v, dir) if v startsWith "2.10" => dir / "scala_2.10"
//}
//src/main/scala      # both 2.9 and 2.10
//src/main/scala_2.9  # source only for 2.9
//src/main/scala_2.10 # source only for 2.10
Try(Source.fromFile("file.txt")) recover {
  case e: FileNotFoundException => "File not existed"
}
def show(): Int = {
  println("hello world")
  7
}
def callByName(x: => Int) = 3
def callByValue(x: Int) = 3
val value = {
  println("........................")
  3
}
callByName(show())
callByName(value)
callByValue(show())


import scala.concurrent.ExecutionContext.Implicits.global
val first = Future{"abc".toInt}
val second = Future{null.getClass; 3}
Thread.sleep(3000)
val complete = first.flatMap(_ => second).onComplete {
  case Failure(ex) => println(ex)
  case a => println(a)
}

println(".........")



def doStuff(x: Int): Int => String = x => x.toString

doStuff(3)

def timed[A](block: => A) = {
  val t0 = System.currentTimeMillis
  val result = block
  println("took " + (System.currentTimeMillis - t0) + "ms")
  result
}

Array.fill(100)(3).head



