package patterMatching

import org.scalatest.FunSuite

class CollectSpecTest extends FunSuite {

  test("heterogeneous sequence can be filtered and grouped") {

    val sequence = Seq[Foo](Corge(1), Qux(Bar("3"), "3"), Qux(Bar("4"), "5"),
      Corge(6), Qux(Bar("3"), "30"))

    val quxSequence : Seq[Qux] = CollectSpec.filter(sequence)

    assert(quxSequence.size === 3)
    assert(quxSequence.head.bar.value === "3")
    assert(quxSequence.last.value === "30")
  }

}
