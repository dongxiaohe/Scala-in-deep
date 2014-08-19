//import org.json4s._
//import org.json4s.jackson.JsonMethods._
//
//val j: JValue = parse("""{
//                            "FormattedID" : "the id",
//                            "PlanEstimate" : 3.0
//                          }""")
//for {
//  JObject(list) <- j
//  JField("FormattedID", JString(id)) <- list
//  JField("PlanEstimate", JDouble(points)) <- list
//} yield (id, points)

def meanofArray(s:Array[Double]) : Double = s.sum/s.length
def meanofArray(s:Array[BigDecimal]) : BigDecimal = s.sum/s.length
meanofArray(Array(1.0, 2.0, 3.0))
meanofArray(Array(BigDecimal("1"), BigDecimal("2"), BigDecimal("3"), BigDecimal("4"), BigDecimal("5")))