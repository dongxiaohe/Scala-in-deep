import shapeless._

def intToString(x: Int) = x + "_"
def intToDouble(x: Int) = x * 10d
val fns = (intToString _ :: intToDouble _ :: HNil)

fns zip (1 :: 2 :: HList) map {case (f, x) => f(x) }