package design.abstration

trait UserModule {

  type User <: UserLike

  trait UserLike { this: User =>
    def name: String
    def password: String

    def save(): Unit
  }

  def User(name: String, password: String): UserLike
}

class A
class B extends A
class C extends B

trait Foo {

  type Bar <: B

  trait DoStuff { self: Bar => {

    val name: String = "123"
  }

  }

}


