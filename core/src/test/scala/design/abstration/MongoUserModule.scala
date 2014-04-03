package design.abstration

trait MongoUserModule extends UserModule {

  class User(val name: String, val password: String) extends UserLike {
    override def save(): Unit = {

    }
  }

  override def User(name: String, password: String) = new User(name, password)

}
