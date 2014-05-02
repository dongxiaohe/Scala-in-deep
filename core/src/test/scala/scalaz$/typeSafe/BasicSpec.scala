package scalaz$.typeSafe

import org.scalatest.FunSuite

class BasicSpec extends FunSuite {

  test("scalaz make === type safe") {


    val versionToYear = Map(
        "1.0" -> "2003", "2.0" -> "2007", "3.0" -> "2013"
      )

      //can not compile
      def isVersionFromYear(version: String, year: String) = {
        versionToYear get version exists (_ === year)
      }
  }
}
