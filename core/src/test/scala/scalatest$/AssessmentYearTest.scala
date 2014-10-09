package scalatest$

import org.scalatest.FunSuite
import org.scalatest.prop.Checkers
import org.scalacheck.{Properties, Prop, Gen}
import org.scalacheck.Prop._
import scalatest$.AssessmentYear

object AssessmentYearTest extends Properties("Assessment year") {

  val years = Gen.choose(2011, 2040)

//  test("lgc assessment year should start from 2001, stc assessment year should start from 2011") {

//    check((a: List[Int], b: List[Int]) => a.size + b.size == (a ::: b).size)

//    check((year: Int) => AssessmentYear(STC, year).getYearRange.head == 2011)
//    check((year: Int) => {
//      year match {
//        case t: Int if t >= 2011 => AssessmentYear(STC, year).getYearRange == (2011 to year)
//        case _ => true
//      }
//    })

//    check((year: Int) => AssessmentYear(STC, year).getYearRange().head == 2011)

    //      cerType match {
    //        case STC => AssessmentYear(cerType, year).getYearRange().head == 2011
    //        case LGC => AssessmentYear(cerType, year).getYearRange().head == 2001
    //      }

  property("2011 is the first year for STC assessment year") = forAll(years)({ year => AssessmentYear(STC, year).getYearRange.head == 2011 })
  property("stc year range") = forAll(years)({ year => AssessmentYear(STC, year).getYearRange == (2011 to year) })
  property("2001 is the first year for LGC assessment year") = forAll(years)({ year => AssessmentYear(LGC, year).getYearRange.head == 2001 })
  property("lgc year range") = forAll(years)({ year => AssessmentYear(LGC, year).getYearRange == (2001 to year) })

//     Prop.forAll(years)({ year => AssessmentYear(STC, year).getYearRange.head == 2010 })

//  }

}
