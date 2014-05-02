package core.patternMatching.extractor

class User(var name: String, var age: Int, var address: Address) {


}

object User {
  def apply(name: String, age: Int, address: Address) = new User(name, age, address)

  def unapply(user: User): Option[(String, Int, Address)] = {
    Some(user.name, user.age, user.address)
  }
}
