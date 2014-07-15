import java.io.File
trait Box { def put(num: Int): Int = { println("Put "+num); num} }
trait FunctionBox extends Box { self =>
  def fn: (Int => Int)
  def andThen(fb: FunctionBox) = new FunctionBox {
    def fn = self.fn andThen fb.fn
  }
  override def put(num: Int): Int = { super.put(fn(num)) }
}
object DoubleBox extends FunctionBox {
  val fn = (x: Int) => 2*x
}
val MyBox = DoubleBox andThen DoubleBox
MyBox.put(3).isInstanceOf[Int]
val intToString = (x: Int) => x.toString
val intToInt = (x: Int) => x + 3
val result = intToInt andThen intToString
result(3)


def bah(c:Char, i:Int = 0) = i
List('a','b','c').map(t =>bah)
List(new File("123")) map { case x: File if x.isFile => {println("sajdfkhsajkfh"); "sdfkljsadfkl"} }
