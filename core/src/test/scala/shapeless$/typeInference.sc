case class KeyMapping[KeyType](k:KeyType)

class WrappedMapping[KeyType](m:T forSome {type T <: KeyMapping[KeyType]}) {
  val k:KeyType = ???
}

new WrappedMapping(KeyMapping("key"))