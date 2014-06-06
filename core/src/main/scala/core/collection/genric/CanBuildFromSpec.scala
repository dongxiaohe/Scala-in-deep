package core.collection.genric

import scala.collection.mutable
import scala.collection.generic.CanBuildFrom

object CanBuildFromSpec {

  def transform[U[_]](col: Array[String])(implicit cbf: CanBuildFrom[Array[String], String, U[String]]): U[String] = {
    val builder = cbf()

    for (ele <- col) builder += ele

    builder.result()
  }

//  def transformElement[From, To](col: Seq[From])
//                                (implicit cbf: CanBuildFrom[Seq[From], To, Seq[To]]): Seq[To] = {
//    val builder = cbf()
//
//    for (ele <- col) builder += ele
//
//    builder.result()
//  }

  def combineValues[U, T[_]](pairs: Seq[(String, U)])
                            (implicit cbf: CanBuildFrom[T[U], U, T[U]]): Seq[(String, T[U])] = {
    val result = mutable.LinkedHashMap[String, mutable.Builder[U, T[U]]]()

    for ((name, value) ← pairs)
      result.getOrElseUpdate(name, cbf()) += value

    result.map { case (k, v) ⇒ k → v.result }.toList
  }

}
