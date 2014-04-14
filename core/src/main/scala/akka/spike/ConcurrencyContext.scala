package akka.spike

import org.specs2.mutable.Specification
import au.gov.cer.registry.infrastructure.operationdispatcher.OperationResponse
import akka.actor.{Props, ActorSystem}
import au.gov.cer.registry.spike.actor.{Master, ResponseProcessor}
import au.gov.cer.registry.testinfrastructure.{CommandBuilder, Context}
import au.gov.cer.registry.spike.message.Initiating

trait ConcurrencyContext { this: Specification =>

  def whenRunInParallel(commandBuilder: CommandBuilder, times: Int) = {
    val system = ActorSystem("system")

    val responseProcessor = system.actorOf(Props[ResponseProcessor], name = "responseProcessor")

    val master = system.actorOf(Props(new Master(times, commandBuilder, responseProcessor)), name = "master")

    println("processing actor...........................")

    master ! Initiating
  }

}
