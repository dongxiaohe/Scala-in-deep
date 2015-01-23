package core.collection

import org.scalatest.FunSuite

class SortBySpec extends FunSuite {

  test("sortBy") {

    class Organization (aId: Int, aName: String) {
      val id:Int = aId
      var name:String = aName
    }

    class User (aId: Int, aOrganizations: List[Organization]) {
      val id:Int = aId
      var organizations:List[Organization] = aOrganizations
    }

    val o1 = new Organization(1, "AAA")
    val o2 = new Organization(2, "AAAA")
    val o3 = new Organization(3, "BBB")
    val o4 = new Organization(4, "BBBB")
    val o5 = new Organization(5, "CCC")
    val o6 = new Organization(6, "AAA BBB")

    val u1  = new User(1,  List(o1))
    val u2  = new User(2,  List(o2))
    val u3  = new User(3,  List(o3))
    val u4  = new User(4,  List(o4))
    val u5  = new User(5,  List(o1,o5))
    val u6  = new User(6,  List(o2,o3))
    val u7  = new User(7,  List(o3,o4))
    val u8  = new User(8,  List(o1,o2,o3,o4))
    val u9  = new User(9,  List(o1,o2,o3,o5))
    val u10 = new User(10, List())
    val u11 = new User(11, List(o6))

    val users = List(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11)

    implicit val organizationOrdering: Ordering[Organization] =
      Ordering.by(_.name)

    val sortedUsers = users.sortBy(_.organizations.toIterable)

  }

}
