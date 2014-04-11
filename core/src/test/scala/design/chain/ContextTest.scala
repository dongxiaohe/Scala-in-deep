package design.chain

import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

class ContextTest extends FlatSpec with Matchers with MockitoSugar {

  "Context" should "chain methods together" in {

    def given[T](context: Context[T]) = context()
    implicit def convertToContext[A](x: => A): Context[A] = Context(() => x)

    trait Dummy {
      def proceed1
      def proceed2
      def proceed3
      def proceedAndThen
      def proceedMap
    }

    val mockDummy = mock[Dummy]
    def doStuff1() : Int = { mockDummy.proceed1; 3 }
    def doStuff2() : String = { mockDummy.proceed2; "3" }
    def doStuff3() : Unit = { mockDummy.proceed3 }
    def withContext() : Context[Int] = Context(() => {mockDummy.proceedAndThen; 3})

    def withMap(x : Int) : Unit = {mockDummy.proceedMap}

    val context: Context[Unit] =
      doStuff1 and doStuff2 and doStuff3 andThen withContext map withMap

    verifyZeroInteractions(mockDummy)

    given(context)

    verify(mockDummy).proceed1
    verify(mockDummy).proceed2
    verify(mockDummy).proceed3
    verify(mockDummy).proceedAndThen
    verify(mockDummy).proceedMap
  }

}
