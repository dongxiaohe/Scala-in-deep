import scalaz._
import Scalaz._

val result = 1.right[String]

result.swap.getOrElse(3)

result.swap.orElse(3.right[String])

//Left[String, Int]("boom") flatMap { x => Right[String, Int](x + 1) }

"boom".left[Int] flatMap { x => (x + 1).right }


3.right[String] flatMap {x => (x + 1) .right}

"event 1 ok".right


for {
  e1 <- "a".right
  e2 <- "b".right[String]
  e3 <- "c".left[String]
} yield e1 |+| e2 |+| e3


"event 2 failed!".left[String]
"event 2 failed!".left[String]| "something good"
~"event 2 failed!".left[String]
~"event 2 failed!".left[String]| "something good"


for {
  e1 <- "a".right
  e2 <- "b".right[String]
  e3 <- "c".right[String]
} yield e1 |+| e2 |+| e3
