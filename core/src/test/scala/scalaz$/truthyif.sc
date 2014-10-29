import scalaz._
import Scalaz._

((x: Int) => x + 1) map {_ * 7}

(1,2,3,4) map {_ + 1}

List(1, 2, 3, 4) map {(_: Int) * (_:Int)}.curried
