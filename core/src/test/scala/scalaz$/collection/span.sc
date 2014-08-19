import scala.util.Random

case class Test(dayOfWeek:Int,b:Int=Random.nextInt)
val data=(3 to 36).map(_ % 7).map(Test(_))
val (firstWeek, nextWeeks) = data.span(_.dayOfWeek != 0)
val weeks = (firstWeek :: nextWeeks.grouped(7).toList).dropWhile(_.isEmpty)