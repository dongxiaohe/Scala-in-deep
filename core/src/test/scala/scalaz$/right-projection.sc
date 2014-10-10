import scalaz._
import Scalaz._

def foo(x: Int) = x.right[String]
def bar(x: String) = x.left[Int]
val result: \/[String,Int] = bar("123").orElse(foo(4))
result.foreach(t => println(t))
//testing flatMap

for {
  a <- 1.right[String]
  b <- 2.right[String]
  c <- 3.right[String]
//  d <- "error".left[Int]
} yield a + b + c

val either = 3.right[String] | "123"
"3".left ||| "4".left ||| "30".right
