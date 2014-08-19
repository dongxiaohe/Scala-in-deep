import scalaz.ValidationNel
import scalaz._
import Scalaz._

case class Foo(singleVal: ValidationNel[Throwable, String])

val x = some(Foo("hey".success))

val y = none[Foo]

println(x.traverseU(_.singleVal))

println(y.traverseU(_.singleVal))