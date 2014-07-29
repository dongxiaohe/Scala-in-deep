abstract  class MainClass
case class Acc(x:String, y:String)  extends MainClass
case class Bcc(x:String, y:String)  extends MainClass
case class Ccc(x:String, y:String)  extends MainClass
trait MainClassFromStrings[T <: MainClass] {
  def apply(x: String, y: String): T
}
implicit def AccFromStrings: MainClassFromStrings[Acc] =
  new MainClassFromStrings[Acc] {
    def apply(x: String, y: String) = Acc(x, y)
  }
implicit def BccFromStrings: MainClassFromStrings[Bcc] =
  new MainClassFromStrings[Bcc] {
    def apply(x: String, y: String) = Bcc(x, y)
  }
implicit def CccFromStrings: MainClassFromStrings[Ccc] =
  new MainClassFromStrings[Ccc] {
    def apply(x: String, y: String) = Ccc(x, y)
  }

def f1[T <: MainClass](implicit fs: MainClassFromStrings[T]) =
  List(fs("sss", "ddd"))

f1[Ccc]