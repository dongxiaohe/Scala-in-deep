package core.collection

object ZipWithIndexSpec {
  def perform(str: Seq[String])(func : String => String, position: Seq[Int]) : Seq[String] = {
    str.zipWithIndex.map {
      case (x, y) if position.contains(y + 1) => func(x)
      case other => other._1
    }
  }

}
