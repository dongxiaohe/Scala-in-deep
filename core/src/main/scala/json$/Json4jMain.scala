package json$

import org.json4s._
import org.json4s.jackson.JsonMethods._

object Json4jMain {

  def main(args: Array[String]) {

//    class NoneJNullSerializer extends CustomSerializer[Option[_]](format =>
//      case JNull => None
//    )
//
//    implicit val formats = DefaultFormats + new NoneJNullSerializer
    implicit val formats: Formats = DefaultFormats + new NoneJNullSerializer()

    val j: JValue = parse("""{
                            "FormattedID" : "the id",
                            "PlanEstimate" : null
                          }""")
    val result = for {
      JObject(list) <- j
      JField("FormattedID", JString(id)) <- list
      JField("PlanEstimate", JDouble(points)) <- list
    } yield (id, points)

    println(result)
  }

}

class NoneJNullSerializer extends CustomSerializer[Option[_]](format => ({ case JNull => None }, { case None => JNull }))
