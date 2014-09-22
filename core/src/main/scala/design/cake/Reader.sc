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

  trait UserRepository {
    def get(id: Int): User
    def find(username: String): User
  }
}

trait UserRepositoryComponentImpl extends UserRepositoryComponent {

  def userRepository = new UserRepositoryImpl

  class UserRepositoryImpl extends UserRepository {

    def get(id: Int) = {
      new User
    }

    def find(username: String) = {
      new User
    }
  }
}

trait UserService { self: UserRepositoryComponent =>

  def saveEmail() = {
    us
  }
}