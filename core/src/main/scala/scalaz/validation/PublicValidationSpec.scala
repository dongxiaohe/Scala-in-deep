package scalaz.validation

import scalaz._
import Scalaz._
import std.string._
import Id._

case class User(name: String, knowScala: Boolean, age: Int)

object PublicValidationSpec extends BasicValidation {
  import scalaz._
  import Scalaz._

//  def validate(user: User): Validation[String, String] = {
//      for {
//           a <- checkAge(user)
//           b <- checkKnowScala(user)
//           c <- checkName(user)
//      } yield s"Congrats, ${c.name}"
//    }


   def validateAll(user: User) = {
     (checkAge(user) |@| checkKnowScala(user) |@| checkName(user)) {
       case(_, _, c) => s"Congrats, ${c.name}"
     }
   }

}

trait BasicValidation {
  def checkName(user: User): Validation[String, User] = {
    if(user.name == "") "must have a name".fail else user.success
  }

  def checkKnowScala(user: User): Validation[String, User] = {
    if(!user.knowScala) "must know a little about scala".fail else user.success
  }

  def checkAge(user: User): Validation[String, User] = {
    if(user.age < 3) "must be a valid age".fail else user.success
  }

}
