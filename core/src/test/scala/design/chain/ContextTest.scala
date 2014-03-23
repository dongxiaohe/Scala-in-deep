package design.chain

import org.scalatest.{FlatSpec, FunSuite}
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import org.mockito.InOrder

class ContextTest extends FlatSpec with ShouldMatchers with MockitoSugar {

  "Context" should "chain methods together" in {

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

    def given[T](context: Context[T]) = context()

    val context: Context[Unit] =
      Context(doStuff1) and doStuff2 and doStuff3 andThen withContext map withMap

    verifyZeroInteractions(mockDummy)

    given(context)
    verify(mockDummy).proceed1
    verify(mockDummy).proceed2
    verify(mockDummy).proceed3
    verify(mockDummy).proceedAndThen
    verify(mockDummy).proceedMap
  }

}
