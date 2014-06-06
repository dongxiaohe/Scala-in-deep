package design.decouple

sealed trait Command

class UserCreateCommand extends Command
class UserUpdateCommand extends Command
class UserDeleteCommand extends Command

class AddressCreateCommand extends Command


