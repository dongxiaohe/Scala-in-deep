package generator

import org.scalatest._
import org.scalatest.mock.MockitoSugar
import org.scalatest.tagobjects.Retryable

class RandomSpec$Test extends FlatSpec with Retries with ShouldMatchers with MockitoSugar {
   var i = 1

  override protected def withFixture(test: NoArgTest): Outcome = {
    if (isRetryable(test))
      withRetry { super.withFixture(test) }
    else
      super.withFixture(test)
  }
  "flicker test" should "be possibly successful" taggedAs Retryable in {
    i += 1
    assert(i === 3)
  }

}
