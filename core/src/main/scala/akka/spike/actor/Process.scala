package akka.spike.actor

import akka.actor.Actor
import au.gov.cer.registry.testinfrastructure.{CommandBuilder, Context}
import au.gov.cer.registry.spike.message.{RunProcess, Result}
import au.gov.cer.registry.infrastructure.operationdispatcher.{OperationDispatcher, OperationResponse}
import org.springframework.beans.factory.annotation.Autowired

class Process extends Actor {

  @Autowired var dispatcher: OperationDispatcher = _

  private def execute(commandBuilder: CommandBuilder): OperationResponse = {
    println("processing..........................................")
    dispatcher.dispatchCommand(commandBuilder.build)
  }

  def receive = {

    case RunProcess(commandBuilder) => sender ! execute(commandBuilder)

  }

}