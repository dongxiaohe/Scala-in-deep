package collection

import scala.collection.mutable
import scala.collection.generic.CanBuildFrom

object CanBuildFromSpec {
  def combineValues[U >: String, T[_]](pairs: Seq[(String, String)])
                            (implicit cbf: CanBuildFrom[T[U], U, T[U]]): Seq[(String, T[U])] = {
    val result = mutable.LinkedHashMap[String, mutable.Builder[String, T[U]]]()

    for ((name, value) ← pairs)
      result.getOrElseUpdate(name, cbf()) += value

    result.map { case (k, v) ⇒ k → v.result }.toList
  }

}
