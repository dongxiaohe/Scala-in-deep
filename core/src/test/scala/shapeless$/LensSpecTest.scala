package shapeless$

import org.scalatest.FunSuite

import shapeless._
class LensSpecTest extends FunSuite {

  case class Address(street : String, city : String, postcode : String)
  case class Person(name : String, age : Int, address : Address)

  test("lens spec") {

    // Some lenses over Person/Address ...
    val nameLens     = lens[Person] >> 'name
    val ageLens      = lens[Person] >> 'age
    val addressLens  = lens[Person] >> 'address
    val streetLens   = lens[Person] >> 'address >> 'street
    val cityLens     = lens[Person] >> 'address >> 'city
    val postcodeLens = lens[Person] >> 'address >> 'postcode

    // Starting value
    val person = Person("Joe Grey", 34, Address("Southover Street", "Brighton", "BN2 9UA"))

    val age1 = ageLens.get(person) // Type inferred is Int

    val person2 = ageLens.set(person)(36)

    assert(age1 == 34)
  }


  test("a bug") {

//    case class A(map: Map[String, String])
//    case class B(a: A)
//
//    val mapLens = lens[B] >> 'a >> 'map
//
//    val b = B(A(Map("123" -> "3")))

    //      mapLens.set(b)(b.a.map + ("foo" -> "bar"))

  }
}