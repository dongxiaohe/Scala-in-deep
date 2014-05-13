package core.function

import org.scalatest.FunSuite

class HighOrderFunctionSpec extends FunSuite {

  test("Customized email filter") {
    case class Email(
            subject: String,
            text: String,
            sender: String,
            recipient: String)

    type EmailFilter = Email => Boolean
    def newMailsForUser(mails: Seq[Email], f: EmailFilter) = mails.filter(f)

    val sentByOneOf: Set[String] => EmailFilter =
      senders => email => senders.contains(email.sender)
    val notSentByAnyOf: Set[String] => EmailFilter =
      senders => email => !senders.contains(email.sender)
    val minimumSize: Int => EmailFilter = n => email => email.text.size >= n
    val maximumSize: Int => EmailFilter = n => email => email.text.size <= n

    type SizeChecker = Int => Boolean
    val sizeConstraint: SizeChecker => EmailFilter = f => email => f(email.text.size)


    def complement[A](predicate: A => Boolean) = (a: A) => !predicate(a)

    def any[A](predicates: (A => Boolean)*): A => Boolean =
      a => predicates.exists(pred => pred(a))
    def none[A](predicates: (A => Boolean)*) = complement(any(predicates: _*))
    def every[A](predicates: (A => Boolean)*) = none(predicates.view.map(complement(_)): _*)

  }

}
