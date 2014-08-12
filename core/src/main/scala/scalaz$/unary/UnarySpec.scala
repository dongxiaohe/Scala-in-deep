package scalaz$.unary

object UnarySpec {

  def main(args: Array[String]) {
    import scalaz._ ; import Scalaz._

    val List(a,b,c,d) = List(Some("str1"), Some("str2"),None,Some("str3"))

    val result = ~a + ~b + ~c + ~d

    println(result)
  }

}