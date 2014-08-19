def mergeWith[K, X, Y, Z](xs: Map[K, X], ys: Map[K, Y])
                         (f: (X, Y) => Z): Map[K, Z] =
  xs.flatMap {
    case (k, x) => ys.get(k).map(k -> f(x, _))
  }

val mapX = Map('a -> 1, 'b -> 2)

val mapY = Map('b -> "foo", 'c -> "bar")

mergeWith(mapX, mapY) { (x, y) => (x, y) }
