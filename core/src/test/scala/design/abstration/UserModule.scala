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
