package shapeless$.generic

import org.scalatest.FunSuite
import shapeless._, ops.function._

class ProductSpec extends FunSuite {

  test("generic either throwable int") {

    def safeify[F, A <: HList, R, O](f: F)(implicit
                                           ftp: FnToProduct.Aux[F, A => R],
                                           ffp: FnFromProduct[A => Either[Throwable, R]]
      ) = ffp((a: A) =>
      try Right(ftp(f)(a)) catch {
        // Replace with your own error handling logic.
        case ex: Throwable => Left(ex)
      }
    )

    def bad(s: String, i: Int) = s.toInt / i

    val better = safeify(bad _)

    better("abc", 0)

  }

}
