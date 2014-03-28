package design.state

import scala.util.{Failure, Try, Success}

object StateSpec {

  trait State {
    def read() : Try[String] = {
      Failure(new IllegalStateException("too young to read"))
    }
  }
  case object child extends State

  case object young extends State {
    override def read() : Try[String] = {
      Success("young people read book")
    }
  }
  case object elder extends State {
    override def read() : Try[String] = {
      Success("elder people read book")
    }
  }

  class Person {
    var state : State = child

    def read() : Try[String] = {
      state.read()
    }

  }

}
