package patternMatching

import org.scalatest.FunSuite

class BooleanExtractorSpec extends FunSuite {

  trait User {
    def name: String
    def score: Int
  }
  class FreeUser(val name: String, val score: Int, val upgradeProbability: Double)
    extends User
  class PremiumUser(val name: String, val score: Int) extends User

  object premiumCandidate {
    def unapply(user: FreeUser): Boolean = user.upgradeProbability > 0.76
  }

  def initiateSpamProgram(user: User) = {
    println("great")
  }


  test("use boolean as extractor") {
    val normalUser: User = new FreeUser("Daniel", 2500, 0.3d)
    normalUser match {
      case freeUser @ premiumCandidate() => initiateSpamProgram(freeUser)
      case _ => println("sorry")
    }

    val premiumUser: User = new FreeUser("Daniel", 2500, 0.9d)
    premiumUser match {
      case freeUser @ premiumCandidate() => initiateSpamProgram(freeUser)
      case _ => println("sorry")
    }
  }

}
