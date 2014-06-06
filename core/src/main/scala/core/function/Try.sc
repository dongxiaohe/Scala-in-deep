def complexCalc(x: Int): Int = x * 2

//def myOperation(x: Int)(y: Int): Int = {
//  val complexVal = complexCalc(x)
//  println("complexVal calculated")
//  complexVal + y
//}
def myOperation(x: Int): Int => Int = {
  val complexVal = complexCalc(x)
  println("complexVal calculated")
  (y: Int) => complexVal + y
}
//val partial = myOperation(5)_
val partial = myOperation(5)


println("calculate")

println("result(3): " + partial(1))

println("result(1): " + partial(3))

class C {
  val (a: String) ={"123"}
}

new C().a

def getIndex[T, CC](seq: CC, value: T)(implicit conv: CC => Seq[T]) = seq.indexOf(value)

getIndex(" 123", '3')

