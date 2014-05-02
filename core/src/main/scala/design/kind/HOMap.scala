package design.kind

class HOMap[K[_], V[_]](delegate: Map[K[Any], V[Any]]) {
  def apply[A](key: K[A]): V[A] =
    delegate(key.asInstanceOf[K[Any]]).asInstanceOf[V[A]]
}

object HOMap {
  def apply[K[_], V[_]](tuples: (K[Any], V[Any])*) =
    new HOMap[K, V](Map(tuples: _*))
}
