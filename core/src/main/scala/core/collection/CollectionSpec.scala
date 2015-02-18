package core.collection

import org.scalatest.FunSuite

class CollectionSpec extends FunSuite {

  test("should do Stuff") {

    object person {
      var age = 0

      def addAge() = {
        age = age + 1
      }
    }

    Range(1, 100).foreach(_ => person.addAge())


    println(person.age)

  }

}
