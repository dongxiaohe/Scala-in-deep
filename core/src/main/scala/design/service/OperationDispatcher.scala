package design.service

class OperationDispatcher {

  def dispatchCommand[T <: Command](command: T)(implicit service: Service[Set[T]]): OperationResponse = {


    null
  }

}
