package collection

object ReplaceAllInSpec {
  def process(str: String, replacements: Map[String, String]): String = {

    replacements.foldLeft(str)((str, keyValue) => {
      keyValue._1.r.replaceAllIn(str, keyValue._2)
    })

  }


}
