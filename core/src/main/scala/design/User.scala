package design

class User

trait UserRepository {
  def get(id: Int): User
  def find(username: String): User
}

trait Users {
  import scalaz.Reader

  def getUser(id: Int) = Reader((userRepository: UserRepository) =>
    userRepository.get(id)
  )

  def findUser(username: String) = Reader((userRepository: UserRepository) =>
    userRepository.find(username)
  )
}

trait UserRepositoryComponent {

  def userRepository: UserRepository

}


trait UserRepositoryComponentImpl extends UserRepositoryComponent {

  def userRepository = new UserRepositoryImpl

}

class UserRepositoryImpl extends UserRepository {

  def get(id: Int) = {
    println("processing.............")
    new User
  }

  def find(username: String) = {
    new User
  }
}
class UserService { self: UserRepositoryComponent =>

  import scalaz.Reader

  def getValidUser(id: Int) = Reader((userRepository: UserRepository) =>
  {
    userRepository.get(id) }
  )
}

object MainClass {
  def main(args: Array[String]) {
    object userService extends UserService with UserRepositoryComponentImpl

    userService.getValidUser(3)(new UserRepositoryImpl {})
  }
}

