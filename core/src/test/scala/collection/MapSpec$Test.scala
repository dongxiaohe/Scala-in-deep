package collection

import org.scalatest.{ShouldMatchers, FlatSpec, FunSuite}
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import scala.collection.SeqView

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

  "map" should "has side effect when using closure" in {

    var i = 0

    def inc = (x : Int) => { i += 1; x}

    List(1, 2, 3).map(inc)

    assert(i === 3)

    val list : SeqView[Int, Seq[_]] = List(1, 2, 3).view.map(inc)

    assert(i === 3)

    list.head

    assert(i === 4)

    list.head

    assert(i === 5)

    val stream : Stream[Int] = List(1, 2, 3).toStream.map(inc)

    stream.head

    assert(i === 6)

    stream.take(1)

    assert(i === 6)

  }

  "fibonacci" should "use infinite collection stream" in {
    def fibs : Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)

    assert(fibs(9) === 34)
  }

}
