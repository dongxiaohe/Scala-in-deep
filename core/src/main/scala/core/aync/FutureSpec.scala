package core.aync

object FutureSpec {


  def main(args: Array[String]) {
    import scalaz._
    import Scalaz._

    val either = 3.right[String] | "123"

  }

}
