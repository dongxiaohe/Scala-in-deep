package akka

import org.scalatest.FunSuite
import akka.actor.{Props, ActorSystem, Actor, ActorLogging}

class BasicSpec extends FunSuite {

  test("basic akka example ") {

    Basic.send
    Basic.send
    Basic.send


  }

}
