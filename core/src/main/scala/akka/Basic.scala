package akka

import akka.actor.{ActorSystem, Props, ActorLogging, Actor}

object Basic {

  def send = {
    val system = ActorSystem("basicSystem")
    val greeter = system.actorOf(Props[GreetingActor], name = "greeter")

    greeter ! Greeting("world")
  }

}

case class Greeting(who: String)

class GreetingActor extends Actor with ActorLogging {
  def receive = {
    case Greeting(who) => log.info("Hello " + who)
  }
}

