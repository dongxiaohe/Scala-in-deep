val xs = List(
  List("a","b"),
  List("c"),
  List("d", "e", "f"))


(xs, xs.map(_.size).scanLeft(0)(_+_)).zipped.map((a, b) => a.zip(Stream.from(b)))