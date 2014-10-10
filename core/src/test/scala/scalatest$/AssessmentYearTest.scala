package scalatest$

import org.scalacheck.{Gen, Properties}
import org.scalatest.FunSuite
import org.scalacheck.Prop._

/**
 * Created by Danny.dong on 10/10/2014.
 */
object AssessmentYearTest extends Properties("Assessment year") {

  val years = Gen.choose(2011, 2040)

   property("2011 is the first year for STC assessment year") =
     forAll(years)({ year => AssessmentYear(STC, year).getYearRange.head == 2011 })

  property("stc year range") =
    forAll(years)({ year => AssessmentYear(STC, year).getYearRange == (2011 to year) })

  property("2001 is the first year for LGC assessment year") =
    forAll(years)({ year => AssessmentYear(LGC, year).getYearRange.head == 2001 })

  property("lgc year range") =
    forAll(years)({ year => AssessmentYear(LGC, year).getYearRange == (2001 to year) })
}
