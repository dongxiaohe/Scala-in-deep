package shapeless$

import org.scalatest.FunSuite
import shapeless._


class FindByTypeSpec extends FunSuite {

  test("find by type") {
    class Dummy
    def findByType[T](xs: Seq[Any])(implicit t: Typeable[T]) =
      xs.flatMap(t.cast).headOption

    val result = findByType[List[String]](Seq(List(1), List("a"), 'foo, new Dummy))

    assert(result === Some(List("a")))

    val dummyObj = new Dummy
    val dummyResult = findByType[Dummy](Seq(List(1), List("a"), 'foo, dummyObj))

    assert(dummyResult === Some(dummyObj))

    println((0 until 3).map(1<<_).foreach(println))
    println((0 until 3).map(1>>_).foreach(println))
  }

}
