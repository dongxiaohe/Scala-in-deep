package design.typeClass

object TypeClassSpec {
  def process[C: Show](x : C) = implicitly[Show[C]].show(x)

  def unaryProcess(x: Int) = {
    implicit val convertShow = new Show[Int] {
      override def show(x: Int) = (1 to x) map(_ => "|") mkString
    }
    convertShow.show(x)
  }

}
trait Show[T] {
  def show(x : T)
}