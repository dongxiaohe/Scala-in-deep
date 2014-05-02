package specs2$.infrastructure

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.Specification
import org.specs2.specification.script.{StepParser, StandardDelimitedStepParsers}
import scala.util.Try
import org.specs2.specification.Fragments

//import org.joda.time.DateTime

@RunWith(classOf[JUnitRunner])
trait BaseGWTSpec extends Specification with StandardDelimitedStepParsers {

    def about: Fragments

    def is = about

  private def convertErrorMessage(typeOfConversion: String, value: String) = String.format("[%s] conversion failure for [%s]", typeOfConversion, value)

  def aBoolean = StepParser((value: String) => Try(value.toBoolean).getOrElse(throw new Exception(convertErrorMessage("Boolean", value))))
//  def aDate = StepParser((value: String) => Try(DateTime.parse(value)).getOrElse(throw new Exception(convertErrorMessage("Date", value))))
}
