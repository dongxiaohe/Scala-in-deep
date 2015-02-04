def listToOption[T](list: List[T]): Option[T] = list.headOption

val t = listToOption _

