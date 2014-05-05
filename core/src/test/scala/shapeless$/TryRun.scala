package shapeless$

import shapeless._
object TryRun extends App {

  case class Address(street : String, city : String, postcode : String)
  case class Person(name : String, age : Int, address : Address)


    val nameLens     = lens[Person] >> 'name
    val ageLens      = lens[Person] >> 'age
    val addressLens  = lens[Person] >> 'address
    val streetLens   = lens[Person] >> 'address >> 'street
    val cityLens     = lens[Person] >> 'address >> 'city
    val postcodeLens = lens[Person] >> 'address >> 'postcode

    // Starting value
    val person = Person("Joe Grey", 34, Address("Southover Street", "Brighton", "BN2 9UA"))

    val age1 = ageLens.get(person) // Type inferred is Int

    println(age1)

    assert(age1 == 34)

}
