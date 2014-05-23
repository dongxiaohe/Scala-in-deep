package design.typeClass.typeSafe

import org.scalatest.FunSuite

class PhantomTypeTest extends FunSuite {

  test("phantom type type check") {


    val service = Service.create()

    service.start()
//    service.stop()

  }

}

sealed trait ServiceState
final class Started extends ServiceState
final class Stopped extends ServiceState

class Service[State <: ServiceState] private () {
  def start[T >: State <: Stopped]() = this.asInstanceOf[Service[Started]]
  def stop[T >: State <: Started]() = this.asInstanceOf[Service[Stopped]]
}
object Service {
  def create() = new Service[Stopped]
}
