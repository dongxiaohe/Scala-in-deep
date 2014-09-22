import scala.collection.BitSet

Seq(1,2,3).par.foreach(println)
def doStuff: (Int, Int) => Int = { (a, b) =>
  a + b

}

val curried = doStuff.curried


