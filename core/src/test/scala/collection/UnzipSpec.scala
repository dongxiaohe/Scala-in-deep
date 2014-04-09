package collection

import org.scalatest.FunSuite

class UnzipSpec extends FunSuite {

  test("zip and unzip List") {

    val list = List(1, 2, 3)
    val listWithZip = list.zip(List("123", "123", "123"))

    assert(listWithZip === List((1, "123"), (2, "123"), (3, "123")))
    assert(listWithZip.unzip === (List(1, 2, 3), List("123", "123", "123")))
    assert(listWithZip.map(_.swap) === List(("123", 1), ("123", 2), ("123", 3)))

  }

  test("zip and unzip Map") {

    val map = Map(1->"123", 2->"123", 3->"123")
    val mapWithZip = map.zip(List("123", "123", "123"))

    assert(mapWithZip === Map((1, "123") -> "123", (2, "123") -> "123", (3, "123") -> "123"))
    assert(map.unzip === (List(1, 2, 3), List("123", "123", "123")))
    assert(map.map(_.swap) === Map("123" -> 3))
    assert(map.groupBy(_._2).map {case (key, value) => (key, value.unzip._1)} === Map("123" -> List(1, 2, 3)))

  }

  test("unzip arbitrary elements") {

    val list = List("hello world", "Erik Myer", "Daniel Spiewak")
    val listWithTuple = list.unzip(e => (e.takeWhile(_ != ' '), e.dropWhile(_ != ' ')))

    assert(listWithTuple === (List("hello", "Erik", "Daniel"), List(" world", " Myer", " Spiewak")))
  }

}
