package shapeless$

import org.scalatest.FunSuite

class LensInPracticalTest extends FunSuite {

  case class Company(name: String, department: Department)
  case class Department(name: String, person: Person)
  case class Person(name: String, address: Address)
  case class Address(suburb: String, state: String, postcode: Int)

  val googleCompany: Company = {
    val address = Address("melbourne", "nsw", 6000)
    val danny = Person("jason", address)
    val itDepartment = Department("IT", danny)
    Company("google", itDepartment)
  }

  test("change person who comes from IT department address postcode from 3000 to 3004") {
    val google = googleCompany

    case class Lens[A, B](get: A => B, set: (A, B) => A) {
      def andThen[C](that: Lens[B, C]): Lens[A, C] = Lens(a => that.get(get(a)), (a, c) => set(a, that.set(get(a), c)))
    }

    val departmentLens: Lens[Company, Department] = Lens(_.department, (a, b) => a.copy(department = b))
    val personLens: Lens[Department, Person] = Lens(_.person, (a, b) => a.copy(person = b))
    val addressLens: Lens[Person, Address] = Lens(_.address, (a, b) => a.copy(address = b))
    val postcodeLens: Lens[Address, Int] = Lens(_.postcode, (a, b) => a.copy(postcode = b))

    val lens: Lens[Company, Int] = departmentLens andThen personLens andThen addressLens andThen postcodeLens

    val result: Company = lens.set(google, 3000)

    assert(result.department.person.address.postcode === 3000)
  }

  test("use shapeless to do it") {
    import shapeless._

    val google = googleCompany

    val postcodeLens: Lens[Company, Int] = lens[Company] >> 'department >> 'person >> 'address >> 'postcode

    val result: Company = postcodeLens.set(google)(3000)

    assert(result.department.person.address.postcode === 3000)
  }

}
