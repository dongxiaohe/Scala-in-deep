package design.abstration

import org.scalatest.FunSuite

class UserModuleTest extends FunSuite {

  test("user module") {
    val mongoUserModule = new MongoUserModule {

    }

    val user = mongoUserModule.User("123", "123")
    user.save()

//    new UserModule {
//
//      override type User = this.type
//
//      override def User(name: String, password: String): User = ???
//    }
  }

}
