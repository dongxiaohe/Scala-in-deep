package patterMatching

import org.scalatest.FunSuite

class CollectSpecTest extends FunSuite {

  test("heterogeneous sequence can be filtered and grouped") {

    val sequence = Seq[Foo](Corge(1), Qux(Bar("3"), "3"), Qux(Bar("4"), "5"),
      Corge(6), Qux(Bar("3"), "7"))

    val quxSequence : Seq[Qux] = CollectSpec.filter(sequence)

    quxSequence.size === 2
    quxSequence.head.bar === 3
    quxSequence.head.bar === 4
  }

}
