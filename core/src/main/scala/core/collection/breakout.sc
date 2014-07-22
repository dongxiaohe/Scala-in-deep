import scala.collection.generic.CanBuildFrom
import scala.language.higherKinds
import scala.collection.breakOut

class Build[To[_]]

def build[To[_]] = new Build[To]

implicit def buildToCbf[From, T, To[_]](b: Build[To])
                                       (implicit cbf: CanBuildFrom[Nothing,T,To[T]]): CanBuildFrom[From,T,To[T]] =
  collection.breakOut

List(1, 2, 3).map{i => (i * 2, i / 2.0, i.toString)}(build[Array])