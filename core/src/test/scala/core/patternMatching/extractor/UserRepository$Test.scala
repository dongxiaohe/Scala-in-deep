package core.patternMatching.extractor

import org.scalatest.FunSuite

class UserRepository$Test extends FunSuite {

  test("user repository find user's name who address is only in melbourne based on pattern matching anonymous functions") {
    val userName = for {
      User(name, _, Address("melbourne", _, _)) <- userRepository.findAll
    } yield name

    assert(userName.size === 1)
    assert(userName.head === "Jason")
  }

  test("user repository find user who address is only in melbourne based on pattern matching anonymous functions") {
    val userInMelbourne = for {
      user@User(_, _, Address("melbourne", _, _)) <- userRepository.findAll
    } yield user

    assert(userInMelbourne.size === 1)
    assert(userInMelbourne.head.name === "Jason")
  }

}
