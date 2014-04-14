package akka.spike.actor

import akka.actor.{Props, ActorRef, Actor}
import akka.routing.RoundRobinRouter
import au.gov.cer.registry.spike.message.{ResponseResult, Result, RunProcess, Initiating}
import au.gov.cer.registry.testinfrastructure.{CommandBuilder, Context}
import scala.collection.mutable.ListBuffer
import au.gov.cer.registry.infrastructure.operationdispatcher.OperationResponse

class Master(numOfProcesses: Int, commandBuilder: CommandBuilder, responseProcessor: ActorRef) extends Actor {

  var numOfResults: Int = _
  val responseBuilder = new ListBuffer[OperationResponse]

  val process = context.actorOf(Props[Process].withRouter(RoundRobinRouter(numOfProcesses)), name = "process")

  def receive = {
    case Initiating => {
      println("processing..........................................123")
      for (i ← 0 until numOfProcesses) process ! RunProcess(commandBuilder)
    }

    case Result(response) =>
      numOfResults += 1
      responseBuilder += response

      if (numOfResults == numOfProcesses) {
        responseProcessor ! ResponseResult(responseBuilder.toList)
        context.stop(self)
      }

  }

}