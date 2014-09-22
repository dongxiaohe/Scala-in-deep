import scalaz._
import Scalaz._
import scalaz.std._
import scalaz.{WriterT,Writer,DList,Id}
import scalaz.syntax.writer._
import scalaz.std.option._
import scalaz.std.list._
import scalaz.std.string._
import scalaz.std.anyVal._
import scalaz.std.vector._
import scalaz.std.tuple._
import scalaz.syntax.equal._
import scalaz.syntax.std.option._
type Logged[A] = Writer[DList[String], A]

def log(message: String): Logged[Unit] = DList(message).tell

// log that we are adding, and return the results of adding x and y
def compute(x: Int, y: Int): Logged[Int] =
  log("adding " + x + " and " + y) as (x+y)

// we log a message "begin", we add two numbers, we log "end",
// neither calls to "log" compute a value, they are only evaluated
// for the "effect" of logging a message, so we can use *> and <* to
// discard the computed value (which in this case is Unit), while
// preserving the value computed in the call to "compute"
def addAndLog(x: Int, y: Int): Logged[Int] =
  log("begin") *> compute(x,y) <* log("end")

val (written,result) = addAndLog(1,2).run