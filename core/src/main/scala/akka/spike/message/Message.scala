package akka.spike.message

import au.gov.cer.registry.testinfrastructure.CommandBuilder
import au.gov.cer.registry.infrastructure.operationdispatcher.OperationResponse

sealed trait Message

case object Initiating extends Message

case class RunProcess(commandBuilder: CommandBuilder) extends Message

case class Result(response: OperationResponse) extends Message

case class ResponseResult(operationResponse: List[OperationResponse]) extends Message
