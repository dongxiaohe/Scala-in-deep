import org.json4s._
import org.json4s.jackson.JsonMethods._

val j: JValue = parse("""{
                            "FormattedID" : "the id",
                            "PlanEstimate" : 3.0
                          }""")
for {
  JObject(list) <- j
  JField("FormattedID", JString(id)) <- list
  JField("PlanEstimate", JDouble(points)) <- list
} yield (id, points)