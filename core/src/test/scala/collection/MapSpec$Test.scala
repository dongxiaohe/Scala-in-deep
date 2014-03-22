package collection

import org.scalatest.{ShouldMatchers, FlatSpec, FunSuite}
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

class MapSpec$Test extends FlatSpec with ShouldMatchers with MockitoSugar {

  "map" should "map expect a method which begins a parameter lists" in {
    trait Dummy {
      def doStuff
    }

    var mockDummy = mock[Dummy]

    List(1, 2, 3) map {mockDummy.doStuff; i: Int => i}

    verify(mockDummy, times(1)).doStuff

    mockDummy = mock[Dummy]

    List(1, 2, 3) map {i: Int => mockDummy.doStuff; i}

    verify(mockDummy, times(3)).doStuff

    mockDummy = mock[Dummy]

    def proc = {mockDummy.doStuff; i: Int => i}

    List(1, 2, 3) map proc

    verify(mockDummy, times(1)).doStuff

    mockDummy = mock[Dummy]

    val procVal = {mockDummy.doStuff; i: Int => i}

    mockDummy = mock[Dummy]

    List(1, 2, 3) map procVal

    verifyZeroInteractions(mockDummy)

  }

}
