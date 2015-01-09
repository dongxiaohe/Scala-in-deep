package core.collection

import org.scalatest.FunSuite

class ForSpec extends FunSuite {

  test("recursive for loop") {
    println(
      for {
        a <- Seq("a", "b")
        b <- Seq("a", "b")
      } yield a + b
    )

    def select[T](n: Int)(input: Seq[T])(func: (T, T) => T): Seq[T] = {
      if (n == 1) input else for {
        c <- input
        r <- select(n-1)(input)(func)
      } yield func(c, r)
    }

    println(select(3)(List("a", "b", "c"))((a, b) => a + b))

  }

}
