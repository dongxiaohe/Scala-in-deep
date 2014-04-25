package scalaz.typeSafe

import org.scalatest.FunSuite

object BasicSpec {

  def main(args: Array[String]) = {

    import scalaz._
    import Scalaz._

    val versionToYear = Map(
      "1.0" -> "2003", "2.0" -> "2007", "3.0" -> "2013"
    )

    def isVersionFromYear(version: String, year: String) = {
      versionToYear get version exists(_ === year)
    }

    println(isVersionFromYear("3.0", "2013"))
    println(isVersionFromYear("3.0", "2015"))

  }

}
