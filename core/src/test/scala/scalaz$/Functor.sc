import scalaz._
import Scalaz._

type IntTuple[+A]=(Int, A)
Functor[IntTuple].map((1, 2))(a => a + 1)