
def idValue(f: Int => Int, x: Int): Int = f(x)

type idType[A[_], B] = A[B]

idValue(x => x+ 1, 3)

import scala.util.continuations._

reset {
  shift { k: (Int=>Int) =>
    k(3)
  } + 1
}