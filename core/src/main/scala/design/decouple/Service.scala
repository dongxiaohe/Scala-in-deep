package design.decouple

import shapeless._
import shapeless.ops.hlist.Selector

sealed trait Service[L <: HList] {

  def execute[T <: Command](command : T): Any

}

class UserService extends Service[UserCreateCommand :: UserUpdateCommand :: UserDeleteCommand :: HNil] {
  override def execute[T <: UserCreateCommand](command: T): Any = ???

  override def execute[T <: UserUpdateCommand](command: T): Any = ???

  override def execute[T <: UserDeleteCommand](command: T): Any = ???
}

class AddressService extends Service[AddressCreateCommand :: HNil] {
  override def execute(): Any = ???
}
